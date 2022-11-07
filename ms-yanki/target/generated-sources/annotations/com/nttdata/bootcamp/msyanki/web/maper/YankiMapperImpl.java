package com.nttdata.bootcamp.msyanki.web.maper;

import com.nttdata.bootcamp.msyanki.domain.Yanki;
import com.nttdata.bootcamp.msyanki.web.model.YankiModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-07T16:02:53-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class YankiMapperImpl implements YankiMapper {

    @Override
    public Yanki modelToEntity(YankiModel model) {
        if ( model == null ) {
            return null;
        }

        Yanki.YankiBuilder yanki = Yanki.builder();

        yanki.id( model.getId() );
        yanki.docNumber( model.getDocNumber() );
        yanki.cellNumber( model.getCellNumber() );
        yanki.cellImei( model.getCellImei() );
        yanki.email( model.getEmail() );
        yanki.accountAssociate( model.getAccountAssociate() );
        yanki.amountPurse( model.getAmountPurse() );

        return yanki.build();
    }

    @Override
    public YankiModel entityToModel(Yanki event) {
        if ( event == null ) {
            return null;
        }

        YankiModel.YankiModelBuilder yankiModel = YankiModel.builder();

        yankiModel.id( event.getId() );
        yankiModel.docNumber( event.getDocNumber() );
        yankiModel.cellNumber( event.getCellNumber() );
        yankiModel.cellImei( event.getCellImei() );
        yankiModel.email( event.getEmail() );
        yankiModel.accountAssociate( event.getAccountAssociate() );
        yankiModel.amountPurse( event.getAmountPurse() );

        return yankiModel.build();
    }

    @Override
    public void update(Yanki entity, Yanki updateEntity) {
        if ( updateEntity == null ) {
            return;
        }

        entity.setDocNumber( updateEntity.getDocNumber() );
        entity.setCellNumber( updateEntity.getCellNumber() );
        entity.setCellImei( updateEntity.getCellImei() );
        entity.setEmail( updateEntity.getEmail() );
        entity.setAccountAssociate( updateEntity.getAccountAssociate() );
        entity.setAmountPurse( updateEntity.getAmountPurse() );
    }
}
