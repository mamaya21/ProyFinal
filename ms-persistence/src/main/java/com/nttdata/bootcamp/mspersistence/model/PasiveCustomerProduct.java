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
    private Integer id;
    private String customerId;
    private String productId;
    private Boolean has_maintenance; // tiene mantenimiento?
    private Double amountMaintenance; //monto mantenimiento
    private Integer amountOperation; //cantidad de operaciones
    private Date dateOperation; //fecha permitida para la operacion
}
