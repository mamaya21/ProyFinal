package com.nttdata.bootcamp.msp2p.web.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class P2PModel {

    private String id;

    @NotBlank(message="Document Number cannot be null or empty")
    private String docNumber;

    @NotBlank(message="CellPhone Number cannot be null or empty")
    private String cellNumber;

    @NotBlank(message="Email cannot be null or empty")
    private String email;

    @NotBlank(message="Amount cannot be null or empty")
    private Double amountBootCoin; //amount purse

}
