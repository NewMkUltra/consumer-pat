package br.com.alelo.consumer.consumerpat.app.mapper;

import br.com.alelo.consumer.consumerpat.app.dto.ConsumerDTO;
import br.com.alelo.consumer.consumerpat.domain.entity.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ConsumerMapperTest {

    @InjectMocks
    private ConsumerMapper consumerMapper;

    @Mock
    private ModelMapper modelMapper;

    private Consumer consumer;
    private ConsumerDTO consumerDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        consumer = new Consumer();
        consumer.setId(1);
        consumer.setFoodCardNumber(123456);
        consumerDTO = new ConsumerDTO();
        consumerDTO.setId(1);
        consumerDTO.setFoodCardNumber(123456);
    }

    @Test
    void testToDTO() {
        when(modelMapper.map(consumer, ConsumerDTO.class)).thenReturn(consumerDTO);
        ConsumerDTO dto = consumerMapper.toDTO(consumer);
        assertEquals(consumerDTO, dto);
        verify(modelMapper, times(1)).map(consumer, ConsumerDTO.class);
    }

    @Test
    void testToEntity() {
        when(modelMapper.map(consumerDTO, Consumer.class)).thenReturn(consumer);
        Consumer entity = consumerMapper.toEntity(consumerDTO);
        assertEquals(consumer, entity);
        verify(modelMapper, times(1)).map(consumerDTO, Consumer.class);
    }

}
