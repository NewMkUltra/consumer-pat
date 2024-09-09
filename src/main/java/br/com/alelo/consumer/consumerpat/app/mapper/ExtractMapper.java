package br.com.alelo.consumer.consumerpat.app.mapper;

import br.com.alelo.consumer.consumerpat.app.dto.ExtractDTO;
import br.com.alelo.consumer.consumerpat.domain.entity.Extract;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExtractMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ExtractDTO toDTO(Extract extract) {
        return modelMapper.map(extract, ExtractDTO.class);
    }

    public Extract toEntity(ExtractDTO extractDTO) {
        return modelMapper.map(extractDTO, Extract.class);
    }
}
