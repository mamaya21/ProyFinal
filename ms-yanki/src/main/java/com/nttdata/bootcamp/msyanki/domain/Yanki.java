package com.nttdata.bootcamp.msyanki.domain;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class Yanki {

    @Id
    private String id;

    @NotNull
    private String docNumber;

    @NotNull
    private String cellNumber;

    @NotNull
    private String cellImei;

    @NotNull
    private String email;

    private int accountAssociate; //associated account, bring from the ms-customer-product service

    @NotNull
    private Double amountPurse; //amount purse

}
