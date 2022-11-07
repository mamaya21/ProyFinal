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
public class PagoP2PModel {

    private String id;

    @NotBlank(message="BootCoin ID buyer cannot be null or empty")
    private String idBuyer; //Yanki ID buyer person

    @NotBlank(message="BootCoin ID seller cannot be null or empty")
    private String idSeller; //Yanki ID seller person

    @NotBlank(message="Amount cannot be null or empty")
    private Double amountOperation; //amount operation
    private Integer modePayment; //1=Yanki, 2=Transferencia
    private Integer status; //0= pendiente de pago, 1=pagado, 2=anulado
    private String numTransaction;


}
