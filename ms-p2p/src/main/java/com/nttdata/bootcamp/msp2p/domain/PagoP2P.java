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

public class PagoP2P {

    @Id
    private String id;

    @NotNull
    private String idBuyer; //Yanki ID buyer person

    @NotNull
    private String idSeller; //Yanki ID seller person

    @NotNull
    private Double amountOperation; //amount operation
    private Integer modePayment; //1=Yanki, 2=Transferencia
    private Integer status; //0= pendiente de pago, 1=pagado, 2=anulado
    private String numTransaction;
}
