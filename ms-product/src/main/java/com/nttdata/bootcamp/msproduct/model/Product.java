package com.nttdata.bootcamp.msproduct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer id;
    private String productType; //"ProductType" filter in "ms-catalog-product"
    private String productSubType; //"ProductSubType" filter in "ms-catalog-product"
    private String productStatus; //"active" or "inactive"
}
