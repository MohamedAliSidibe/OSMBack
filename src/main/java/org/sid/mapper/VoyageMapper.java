package org.sid.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.sid.dto.VoyageDTO;
import org.sid.entities.Voyage;

@Mapper(componentModel = "spring")
public interface VoyageMapper {
    VoyageMapper INSTANCE = Mappers.getMapper(VoyageMapper.class);

    Voyage toEntity(VoyageDTO voyageDTO);

    VoyageDTO toDTO(Voyage voyage);
}
