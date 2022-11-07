package com.nttdata.bootcamp.mspersistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//separate the active from the passive by the function that each one fulfills
public class ActiveCustomerProduct {
    @Id
    private Integer id;                     //id
    private String productId;
    private String customerId;
    private String customerType;            //N = Natural, B = Business
    private Double amountCredit;            //Credit amount
    private Double debtCredit;              //Credit debt
    private Double limitCredit;             //Credit limit
    private Integer dayPayment;             //Payment day
    private Integer dayCutOff;              //Cutoff day
    private String status;                  //active - inactive
}
