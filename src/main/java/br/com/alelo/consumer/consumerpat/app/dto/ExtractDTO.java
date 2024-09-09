package br.com.alelo.consumer.consumerpat.app.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExtractDTO {

    private int id;
    private int establishmentNameId;
    private String establishmentName;
    private String productDescription;
    private Date dateBuy;
    private int cardNumber;
    private double amount;
}