package br.com.alelo.consumer.consumerpat.domain;

import br.com.alelo.consumer.consumerpat.app.dto.ConsumerDTO;
import br.com.alelo.consumer.consumerpat.domain.service.ConsumerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ConsumerServiceTest {

    @Mock
    private ConsumerService consumerService;

    private ConsumerDTO consumerDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        consumerDTO = new ConsumerDTO();
        consumerDTO.setId(1);
        consumerDTO.setFoodCardNumber(123456);
    }

    @Test
    void testGetAllConsumers() {
        when(consumerService.getAllConsumers()).thenReturn(Arrays.asList(consumerDTO));
        List<ConsumerDTO> consumers = consumerService.getAllConsumers();
        assertEquals(1, consumers.size());
        assertEquals(consumerDTO.getId(), consumers.get(0).getId());
        assertEquals(consumerDTO.getFoodCardNumber(), consumers.get(0).getFoodCardNumber());
        verify(consumerService, times(1)).getAllConsumers();
    }

    @Test
    void testCreateConsumer() {
        doNothing().when(consumerService).createConsumer(consumerDTO);
        consumerService.createConsumer(consumerDTO);
        verify(consumerService, times(1)).createConsumer(consumerDTO);
    }

    @Test
    void testUpdateConsumer() {
        doNothing().when(consumerService).updateConsumer(consumerDTO);
        consumerService.updateConsumer(consumerDTO);
        verify(consumerService, times(1)).updateConsumer(consumerDTO);
    }

    @Test
    void testSetCardBalance() {
        doNothing().when(consumerService).setCardBalance(anyInt(), anyDouble());
        consumerService.setCardBalance(123456, 100.0);
        verify(consumerService, times(1)).setCardBalance(123456, 100.0);
    }

    @Test
    void testBuy() {
        doNothing().when(consumerService).buy(anyInt(), anyString(), anyInt(), anyString(), anyDouble());
        consumerService.buy(1, "Store", 123456, "Product", 50.0);
        verify(consumerService, times(1)).buy(1, "Store", 123456, "Product", 50.0);
    }
}