package br.com.alelo.consumer.consumerpat.domain.service;


import br.com.alelo.consumer.consumerpat.app.dto.ConsumerDTO;
import java.util.List;

public interface ConsumerService {

    List<ConsumerDTO> getAllConsumers();

    void createConsumer(ConsumerDTO consumerDTO);

    void updateConsumer(ConsumerDTO consumerDTO);

    void setCardBalance(int cardNumber, double value);

    void buy(int establishmentType, String establishmentName, int cardNumber,
             String productDescription,
             double value);
}