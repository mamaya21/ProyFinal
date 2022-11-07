package com.nttdata.bootcamp.msp2p.web.maper;

import com.nttdata.bootcamp.msp2p.domain.P2P;
import com.nttdata.bootcamp.msp2p.web.model.P2PModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface P2PMapper {

    P2P modelToEntity (P2PModel model);

    P2PModel entityToModel (P2P event);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget P2P entity, P2P updateEntity);

}
