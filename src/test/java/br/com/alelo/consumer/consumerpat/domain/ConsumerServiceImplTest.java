package br.com.alelo.consumer.consumerpat.domain;

import br.com.alelo.consumer.consumerpat.app.dto.ConsumerDTO;
import br.com.alelo.consumer.consumerpat.app.mapper.ConsumerMapper;
import br.com.alelo.consumer.consumerpat.domain.entity.Consumer;
import br.com.alelo.consumer.consumerpat.domain.service.ConsumerServiceImpl;
import br.com.alelo.consumer.consumerpat.infra.ConsumerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ConsumerServiceImplTest {

    @InjectMocks
    private ConsumerServiceImpl consumerService;

    @Mock
    private ConsumerRepository consumerRepository;


    @Mock
    private ConsumerMapper consumerMapper;


    private Consumer consumer;
    private ConsumerDTO consumerDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        consumer = new Consumer();
        consumer.setId(1);
        consumer.setFoodCardNumber(123456);
        consumer.setFoodCardBalance(100.0);
        consumerDTO = new ConsumerDTO();
        consumerDTO.setId(1);
        consumerDTO.setFoodCardNumber(123456);
        consumerDTO.setFoodCardBalance(100.0);
    }

    @Test
    void testGetAllConsumers() {
        when(consumerRepository.getAllConsumersList()).thenReturn(Arrays.asList(consumer));
        when(consumerMapper.toDTO(any(Consumer.class))).thenReturn(consumerDTO);
        assertEquals(1, consumerService.getAllConsumers().size());
    }

    @Test
    void testFindConsumerByCardNumber_NotFound() {
        when(consumerRepository.findByFoodCardNumber(anyInt())).thenReturn(null);
        when(consumerRepository.findByFuelCardNumber(anyInt())).thenReturn(null);
        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            consumerService.findConsumerByCardNumber(123456);
        });
        assertEquals("Card not found", exception.getMessage());
    }

    @Test
    void testCreateConsumer() {
        ConsumerDTO consumerDTO = new ConsumerDTO();
        Consumer consumer = new Consumer();
        when(consumerMapper.toEntity(consumerDTO)).thenReturn(consumer);
        consumerService.createConsumer(consumerDTO);
        verify(consumerMapper, times(1)).toEntity(consumerDTO);
        verify(consumerRepository, times(1)).save(consumer);
    }

}