package br.com.alelo.consumer.consumerpat.app.dto;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerDTO {

    private Integer id;
    private String name;
    private int documentNumber;
    private Date birthDate;

    private int mobilePhoneNumber;
    private int residencePhoneNumber;
    private int phoneNumber;
    private String email;

   private AddressDTO addressDTO;


    private int foodCardNumber;
    private double foodCardBalance;
    private int fuelCardNumber;
    private double fuelCardBalance;
    private int drugstoreNumber;
    private double drugstoreCardBalance;
}