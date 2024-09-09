package br.com.alelo.consumer.consumerpat.domain.service;

import br.com.alelo.consumer.consumerpat.app.dto.ConsumerDTO;
import br.com.alelo.consumer.consumerpat.app.dto.ExtractDTO;
import br.com.alelo.consumer.consumerpat.domain.entity.Consumer;
import br.com.alelo.consumer.consumerpat.domain.entity.Extract;
import br.com.alelo.consumer.consumerpat.app.handler.EntidadeNaoEncontrada;
import br.com.alelo.consumer.consumerpat.app.mapper.ConsumerMapper;
import br.com.alelo.consumer.consumerpat.app.mapper.ExtractMapper;
import br.com.alelo.consumer.consumerpat.infra.ConsumerRepository;
import br.com.alelo.consumer.consumerpat.infra.ExtractRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
@Scope("singleton")
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private ExtractRepository extractRepository;

    @Autowired
    private ConsumerMapper consumerMapper;

    @Autowired
    private ExtractMapper extractMapper;
    @Cacheable
    @Override
    public List<ConsumerDTO> getAllConsumers() {
        log.info("Obtendo todos os consumidores");
        List<Consumer> consumers = consumerRepository.getAllConsumersList();
        return consumers.stream()
                .map(consumerMapper::toDTO)
                .toList();
    }

    @Override
    public void createConsumer(ConsumerDTO consumerDTO) {
        log.info("Criando novo consumidor: {}", consumerDTO);
        Consumer consumer = consumerMapper.toEntity(consumerDTO);
        consumerRepository.save(consumer);
    }

    @Override
    public void updateConsumer(ConsumerDTO consumerDTO) {
        log.info("Atualizando consumidor: {}", consumerDTO);
        Consumer consumer = consumerRepository.findById(consumerDTO.getId())
                .orElseThrow(() -> new EntidadeNaoEncontrada("Consumer not found"));
        consumerMapper.updateConsumerFromDTO(consumerDTO, consumer);
        consumerRepository.save(consumer);
    }

    @Override
    public void setCardBalance(int cardNumber, double value) {
        log.info("Definindo saldo do cartão {}: {}", cardNumber, value);
        Consumer consumer = findConsumerByCardNumber(cardNumber);
        updateCardBalance(consumer, cardNumber, value);
    }

    @Override
    public void buy(int establishmentType, String establishmentName, int cardNumber, String productDescription, double value) {
        log.info("Realizando compra no cartão {}: {} - Valor: {}", cardNumber, establishmentName, value);
        Consumer consumer = findConsumerByCardNumber(cardNumber);
        double adjustedValue = adjustValueForEstablishment(establishmentType, value);
        updateCardBalance(consumer, cardNumber, -adjustedValue);

        ExtractDTO extractDTO = new ExtractDTO(
                0,
                0,
                establishmentName,
                productDescription,
                new Date(),
                cardNumber,
                adjustedValue
        );
        Extract extract = extractMapper.toEntity(extractDTO);
        extractRepository.save(extract);
    }
    @Cacheable
    public Consumer findConsumerByCardNumber(int cardNumber) {
        Consumer consumer = consumerRepository.findByFoodCardNumber(cardNumber);
        if (consumer != null) {
            return consumer;
        }
        consumer = consumerRepository.findByFuelCardNumber(cardNumber);
        if (consumer != null) {
            return consumer;
        }
        throw new EntityNotFoundException("Card not found");
    }

    private void updateCardBalance(Consumer consumer, int cardNumber, double value) {
        if (consumer.getFoodCardNumber() == cardNumber) {
            consumer.setFoodCardBalance(consumer.getFoodCardBalance() + value);
        } else if (consumer.getFuelCardNumber() == cardNumber) {
            consumer.setFuelCardBalance(consumer.getFuelCardBalance() + value);
        } else {
            throw new RuntimeException("Card number does not match any known card type.");
        }
        consumerRepository.save(consumer);
    }
    private double adjustValueForEstablishment(int establishmentType, double value) {
        if (establishmentType == 1) {
            double cashback = (value / 100) * 10;
            return value - cashback;
        } else if (establishmentType == 3) {
            double tax = (value / 100) * 35;
            return value + tax;
        }
        return value;
    }
}