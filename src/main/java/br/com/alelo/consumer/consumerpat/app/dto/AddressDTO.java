package br.com.alelo.consumer.consumerpat.app.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private Integer id;
    private String street;
    private int number;
    private String city;
    private String country;
    private int postalCode;
}
