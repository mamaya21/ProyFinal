package com.nttdata.bootcamp.msp2p.web.maper;

import com.nttdata.bootcamp.msp2p.domain.P2P;
import com.nttdata.bootcamp.msp2p.web.model.P2PModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-07T15:45:38-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class P2PMapperImpl implements P2PMapper {

    @Override
    public P2P modelToEntity(P2PModel model) {
        if ( model == null ) {
            return null;
        }

        P2P.P2PBuilder p2P = P2P.builder();

        p2P.id( model.getId() );
        p2P.docNumber( model.getDocNumber() );
        p2P.cellNumber( model.getCellNumber() );
        p2P.email( model.getEmail() );
        p2P.amountBootCoin( model.getAmountBootCoin() );

        return p2P.build();
    }

    @Override
    public P2PModel entityToModel(P2P event) {
        if ( event == null ) {
            return null;
        }

        P2PModel.P2PModelBuilder p2PModel = P2PModel.builder();

        p2PModel.id( event.getId() );
        p2PModel.docNumber( event.getDocNumber() );
        p2PModel.cellNumber( event.getCellNumber() );
        p2PModel.email( event.getEmail() );
        p2PModel.amountBootCoin( event.getAmountBootCoin() );

        return p2PModel.build();
    }

    @Override
    public void update(P2P entity, P2P updateEntity) {
        if ( updateEntity == null ) {
            return;
        }

        entity.setDocNumber( updateEntity.getDocNumber() );
        entity.setCellNumber( updateEntity.getCellNumber() );
        entity.setEmail( updateEntity.getEmail() );
        entity.setAmountBootCoin( updateEntity.getAmountBootCoin() );
    }
}
