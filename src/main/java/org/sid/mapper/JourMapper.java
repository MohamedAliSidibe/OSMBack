package org.sid.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.dto.JourDTO;
import org.sid.entities.Jour;

@Mapper(componentModel = "spring")
public interface JourMapper {
    JourMapper INSTANCE = Mappers.getMapper(JourMapper.class);
    Jour toEntity(JourDTO jourDTO);
    JourDTO toDTO(Jour jour);
}
