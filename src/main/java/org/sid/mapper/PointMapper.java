package org.sid.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.dto.PointEntityDTO;
import org.sid.entities.PointEntity;


@Mapper(componentModel = "spring")
public interface PointMapper {
    PointMapper INSTANCE = Mappers.getMapper(PointMapper.class);

    PointEntityDTO toDTO(PointEntity point);

    PointEntity toEntity(PointEntityDTO pointDTO);

}
