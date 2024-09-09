package br.com.alelo.consumer.consumerpat.app.mapper;

import br.com.alelo.consumer.consumerpat.app.dto.ConsumerDTO;
import br.com.alelo.consumer.consumerpat.domain.entity.Consumer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ConsumerDTO toDTO(Consumer consumer) {
        return modelMapper.map(consumer, ConsumerDTO.class);
    }

    public Consumer toEntity(ConsumerDTO consumerDTO) {
        return modelMapper.map(consumerDTO, Consumer.class);
    }

    public void updateConsumerFromDTO(ConsumerDTO consumerDTO, Consumer consumer) {
        modelMapper.map(consumerDTO, consumer);
    }
}