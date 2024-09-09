package br.com.alelo.consumer.consumerpat.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private int documentNumber;
    @Column
    private Date birthDate;
    @Column
    private int mobilePhoneNumber;
    @Column
    private int residencePhoneNumber;
    @Column
    private int phoneNumber;
    @Column
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private  Address address;
    @Column
    private int foodCardNumber;
    @Column
    private double foodCardBalance;
    @Column
    private int fuelCardNumber;
    @Column
    private double fuelCardBalance;
    @Column
    private double drugstoreCardBalance;
    @Column
    private int drugstoreNumber;

}