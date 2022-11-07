package com.nttdata.bootcamp.msp2p.web.maper;

import com.nttdata.bootcamp.msp2p.domain.PagoP2P;
import com.nttdata.bootcamp.msp2p.web.model.PagoP2PModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-07T15:45:38-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class PagoP2PMapperImpl implements PagoP2PMapper {

    @Override
    public PagoP2P modelToEntity(PagoP2PModel model) {
        if ( model == null ) {
            return null;
        }

        PagoP2P.PagoP2PBuilder pagoP2P = PagoP2P.builder();

        pagoP2P.id( model.getId() );
        pagoP2P.idBuyer( model.getIdBuyer() );
        pagoP2P.idSeller( model.getIdSeller() );
        pagoP2P.amountOperation( model.getAmountOperation() );
        pagoP2P.modePayment( model.getModePayment() );
        pagoP2P.status( model.getStatus() );
        pagoP2P.numTransaction( model.getNumTransaction() );

        return pagoP2P.build();
    }

    @Override
    public PagoP2PModel entityToModel(PagoP2P event) {
        if ( event == null ) {
            return null;
        }

        PagoP2PModel.PagoP2PModelBuilder pagoP2PModel = PagoP2PModel.builder();

        pagoP2PModel.id( event.getId() );
        pagoP2PModel.idBuyer( event.getIdBuyer() );
        pagoP2PModel.idSeller( event.getIdSeller() );
        pagoP2PModel.amountOperation( event.getAmountOperation() );
        pagoP2PModel.modePayment( event.getModePayment() );
        pagoP2PModel.status( event.getStatus() );
        pagoP2PModel.numTransaction( event.getNumTransaction() );

        return pagoP2PModel.build();
    }

    @Override
    public void update(PagoP2P entity, PagoP2P updateEntity) {
        if ( updateEntity == null ) {
            return;
        }

        entity.setIdBuyer( updateEntity.getIdBuyer() );
        entity.setIdSeller( updateEntity.getIdSeller() );
        entity.setAmountOperation( updateEntity.getAmountOperation() );
        entity.setModePayment( updateEntity.getModePayment() );
        entity.setStatus( updateEntity.getStatus() );
        entity.setNumTransaction( updateEntity.getNumTransaction() );
    }
}
