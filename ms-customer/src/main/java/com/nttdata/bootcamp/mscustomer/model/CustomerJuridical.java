package com.nttdata.bootcamp.mscustomer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerJuridical {

    private Integer id;
    private String numberRUC; //RUC 20, 10
    private String nameBusiness; //Razon Social
    private String telephone;
    private String addressFiscal;
    private String status;
    private List<CustomerNatural> holders;

}
