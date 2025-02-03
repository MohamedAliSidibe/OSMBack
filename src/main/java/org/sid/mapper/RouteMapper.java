package org.sid.mapper;


import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;
import org.sid.dto.RouteDTO;
import org.sid.entities.Route;



@Mapper(componentModel = "spring")
public interface RouteMapper {
    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);


    RouteDTO toDTO(Route route);

    Route toEntity(RouteDTO routeDTO);

}
