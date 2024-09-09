package br.com.alelo.consumer.consumerpat.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Extract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int establishmentNameId;
    @Column
    private String establishmentName;
    @Column
    private String productDescription;
    @Column
    private Date dateBuy;
    @Column
    private int cardNumber;
    @Column
    private double amount;


}
