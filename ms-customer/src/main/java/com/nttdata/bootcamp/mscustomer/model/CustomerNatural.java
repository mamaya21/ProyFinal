package com.nttdata.bootcamp.mscustomer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerNatural {

    private Integer id;
    private String docType; //DNI = 1, Carnet de Extranjería = 2
    private String docNumber;
    private String fullName;
    private String telephone;
    private String address;
    private String status;
}
