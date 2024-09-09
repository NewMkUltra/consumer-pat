package br.com.alelo.consumer.consumerpat.app.mapper;

import br.com.alelo.consumer.consumerpat.app.dto.ExtractDTO;
import br.com.alelo.consumer.consumerpat.domain.entity.Extract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ExtractMapperTest {

    @InjectMocks
    private ExtractMapper extractMapper;

    @Mock
    private ModelMapper modelMapper;

    private Extract extract;
    private ExtractDTO extractDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        extract = new Extract();
        extract.setId(1);
        extract.setAmount(100.0);
        extractDTO = new ExtractDTO();
        extractDTO.setId(1);
        extractDTO.setAmount(100.0);
    }

    @Test
    void testToDTO() {
        when(modelMapper.map(extract, ExtractDTO.class)).thenReturn(extractDTO);
        ExtractDTO dto = extractMapper.toDTO(extract);
        assertEquals(extractDTO, dto);
        verify(modelMapper, times(1)).map(extract, ExtractDTO.class);
    }

    @Test
    void testToEntity() {
        when(modelMapper.map(extractDTO, Extract.class)).thenReturn(extract);
        Extract entity = extractMapper.toEntity(extractDTO);
        assertEquals(extract, entity);
        verify(modelMapper, times(1)).map(extractDTO, Extract.class);
    }
}