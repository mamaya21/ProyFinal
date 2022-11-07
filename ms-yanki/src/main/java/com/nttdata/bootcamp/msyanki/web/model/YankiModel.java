package com.nttdata.bootcamp.msyanki.web.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class YankiModel {

    private String id;

    @NotBlank(message="Document Number cannot be null or empty")
    private String docNumber;

    @NotBlank(message="CellPhone Number cannot be null or empty")
    private String cellNumber;

    @NotBlank(message="CellPhone IMEI cannot be null or empty")
    private String cellImei;

    @NotBlank(message="Email cannot be null or empty")
    private String email;

    private int accountAssociate; //associated account, bring from the ms-customer-product service

    @NotBlank(message="Amount cannot be null or empty")
    private Double amountPurse; //amount purse

}
