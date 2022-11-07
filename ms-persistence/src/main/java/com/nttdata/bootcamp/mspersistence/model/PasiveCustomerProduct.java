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
public class PasiveCustomerProduct {
    @Id
    private Integer id;                      //id
    private String numAccount;              //Account number
    private String numAccountCCI;           //Account number interbank
    private String numCard;                 //Card number
    private String productId;
    private String customerId;
    private String customerType;            //N = Natural, B = Business
    private Boolean hasMaintenance;         //Maintenance?
    private Double amountMaintenance;       //Amount of maintenance
    private Boolean hasMovementLimit;       //Has movement limit?
    private Integer amountMovementLimit;    //Amount movement limit
    private Integer dayInMonthMovement;     //Day in the month to perform an operation
    private String status;                  //active - inactive
}
