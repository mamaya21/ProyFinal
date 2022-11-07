package com.nttdata.bootcamp.mspersistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerJuridical {
    @Id
    private Integer id;
    private String numberRUC; //RUC 20, 10
    private String nameBusiness; //Razon Social
    private String telephone;
    private String addressFiscal;
    private String status;
    private List<CustomerNatural> holders;
}
