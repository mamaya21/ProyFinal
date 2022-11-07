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
public class Product {

    @Id
    private Integer id;
    private String productType; //"ProductType" filter in "ms-catalog-product"
    private String productSubType; //"ProductSubType" filter in "ms-catalog-product"
    private String productStatus; //"active" or "inactive"

}
