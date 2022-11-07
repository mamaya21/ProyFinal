package com.nttdata.bootcamp.msyanki.web.maper;

import com.nttdata.bootcamp.msyanki.domain.PagoYanki;
import com.nttdata.bootcamp.msyanki.web.model.PagoYankiModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PagoYankiMapper {

    PagoYanki modelToEntity (PagoYankiModel model);

    PagoYankiModel entityToModel (PagoYanki event);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget PagoYanki entity, PagoYanki updateEntity);

}
