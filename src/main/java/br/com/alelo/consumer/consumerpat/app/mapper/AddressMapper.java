package br.com.alelo.consumer.consumerpat.app.mapper;


import br.com.alelo.consumer.consumerpat.app.dto.AddressDTO;
import br.com.alelo.consumer.consumerpat.domain.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    @Autowired
    private ModelMapper modelMapper;

    public AddressDTO toDTO(Address address) {
        return modelMapper.map(address, AddressDTO.class);
    }

    public Address toEntity(AddressDTO addressDTO) {
        return modelMapper.map(addressDTO, Address.class);
    }
}
