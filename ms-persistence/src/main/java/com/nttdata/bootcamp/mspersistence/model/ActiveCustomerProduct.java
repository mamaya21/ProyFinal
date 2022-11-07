package com.nttdata.bootcamp.mspersistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//separate the active from the passive by the function that each one fulfills
public class ActiveCustomerProduct {
    @Id
    private Integer id;
    private String customerId;
    private String productId;
    private Double amountCredit; //monto
    private Double debtCredit; //deuda
    private Double limitCredit; //limite crediticio
}
