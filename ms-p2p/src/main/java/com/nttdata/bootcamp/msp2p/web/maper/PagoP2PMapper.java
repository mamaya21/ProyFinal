package com.nttdata.bootcamp.msp2p.web.maper;

import com.nttdata.bootcamp.msp2p.domain.PagoP2P;
import com.nttdata.bootcamp.msp2p.web.model.PagoP2PModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PagoP2PMapper {

    PagoP2P modelToEntity (PagoP2PModel model);

    PagoP2PModel entityToModel (PagoP2P event);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget PagoP2P entity, PagoP2P updateEntity);

}
