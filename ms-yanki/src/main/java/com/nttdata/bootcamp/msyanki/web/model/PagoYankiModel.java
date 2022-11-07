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
public class PagoYankiModel {

    private String id;

    @NotBlank(message="Yankie ID transmitter cannot be null or empty")
    private String idTransmitter; //Yanki ID transmitter person

    @NotBlank(message="Yanki ID receiver cannot be null or empty")
    private String idReceiver; //Yanki ID receiver person

    @NotBlank(message="Amount cannot be null or empty")
    private Double amountSend; //amount send for transmitter

    private String descriptionSend; //description send for transmitter

}
