package com.nttdata.bootcamp.mscustomerproduct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//separate the active from the passive by the function that each one fulfills

public class PasiveCustomerProduct {

    private String id; //account number
    private String customerId;
    private String productId;
    private Boolean has_maintenance; // tiene mantenimiento?
    private Double amountMaintenance; //monto mantenimiento
    private Integer amountOperation; //cantidad de operaciones
    private Date dateOperation; //fecha permitida para la operacion
}
