package com.nttdata.bootcamp.msyanki.web.maper;

import com.nttdata.bootcamp.msyanki.domain.PagoYanki;
import com.nttdata.bootcamp.msyanki.web.model.PagoYankiModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-07T16:02:53-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class PagoYankiMapperImpl implements PagoYankiMapper {

    @Override
    public PagoYanki modelToEntity(PagoYankiModel model) {
        if ( model == null ) {
            return null;
        }

        PagoYanki.PagoYankiBuilder pagoYanki = PagoYanki.builder();

        pagoYanki.id( model.getId() );
        pagoYanki.idTransmitter( model.getIdTransmitter() );
        pagoYanki.idReceiver( model.getIdReceiver() );
        pagoYanki.amountSend( model.getAmountSend() );
        pagoYanki.descriptionSend( model.getDescriptionSend() );

        return pagoYanki.build();
    }

    @Override
    public PagoYankiModel entityToModel(PagoYanki event) {
        if ( event == null ) {
            return null;
        }

        PagoYankiModel.PagoYankiModelBuilder pagoYankiModel = PagoYankiModel.builder();

        pagoYankiModel.id( event.getId() );
        pagoYankiModel.idTransmitter( event.getIdTransmitter() );
        pagoYankiModel.idReceiver( event.getIdReceiver() );
        pagoYankiModel.amountSend( event.getAmountSend() );
        pagoYankiModel.descriptionSend( event.getDescriptionSend() );

        return pagoYankiModel.build();
    }

    @Override
    public void update(PagoYanki entity, PagoYanki updateEntity) {
        if ( updateEntity == null ) {
            return;
        }

        entity.setIdTransmitter( updateEntity.getIdTransmitter() );
        entity.setIdReceiver( updateEntity.getIdReceiver() );
        entity.setAmountSend( updateEntity.getAmountSend() );
        entity.setDescriptionSend( updateEntity.getDescriptionSend() );
    }
}
