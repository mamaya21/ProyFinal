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

public class PagoYanki {

    @Id
    private String id;

    @NotNull
    private String idTransmitter; //Yanki ID transmitter person

    @NotNull
    private String idReceiver; //Yanki ID receiver person

    @NotNull
    private Double amountSend; //amount send for transmitter

    private String descriptionSend; //description send for transmitter
}
