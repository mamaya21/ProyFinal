package com.nttdata.bootcamp.msp2p.domain;
import javax.validation.constraints.NotBlank;
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


public class P2P {

    @Id
    private String id;

    @NotNull
    private String docNumber;

    @NotNull
    private String cellNumber;

    @NotNull
    private String email;

    @NotNull
    private Double amountBootCoin; //amount purse

}
