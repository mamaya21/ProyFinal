package com.nttdata.bootcamp.mscatalog.web.maper;

import com.nttdata.bootcamp.mscatalog.domain.Catalog;
import com.nttdata.bootcamp.mscatalog.web.model.CatalogModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-03T14:21:21-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class CatalogMapperImpl implements CatalogMapper {

    @Override
    public Catalog modelToEntity(CatalogModel model) {
        if ( model == null ) {
            return null;
        }

        Catalog.CatalogBuilder catalog = Catalog.builder();

        catalog.id( model.getId() );
        catalog.parameter( model.getParameter() );
        catalog.value( model.getValue() );

        return catalog.build();
    }

    @Override
    public CatalogModel entityToModel(Catalog event) {
        if ( event == null ) {
            return null;
        }

        CatalogModel.CatalogModelBuilder catalogModel = CatalogModel.builder();

        catalogModel.id( event.getId() );
        catalogModel.parameter( event.getParameter() );
        catalogModel.value( event.getValue() );

        return catalogModel.build();
    }

    @Override
    public void update(Catalog entity, Catalog updateEntity) {
        if ( updateEntity == null ) {
            return;
        }

        entity.setParameter( updateEntity.getParameter() );
        entity.setValue( updateEntity.getValue() );
    }
}
