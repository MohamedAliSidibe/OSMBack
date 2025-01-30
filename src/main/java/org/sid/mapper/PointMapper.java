package org.sid.mapper;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.sid.dto.PointEntityDTO;
import org.sid.entities.PointEntity;


import java.util.List;

@Mapper(componentModel = "spring")
public interface PointMapper {
    PointMapper INSTANCE = Mappers.getMapper(PointMapper.class);
    GeometryFactory geometryFactory = new GeometryFactory();
    @Mapping(source = "coordinates", target = "coordinates", qualifiedByName = "listToPoint")
    PointEntity toEntity(PointEntityDTO pointDTO);
    @Mapping(source = "coordinates", target = "coordinates", qualifiedByName = "pointToList")
    PointEntityDTO toDTO(PointEntity point);

    @Named("listToPoint")
    default Point listToPoint(List<Double> coordinates) {
        if (coordinates == null || coordinates.size() < 2) return null;
        return geometryFactory.createPoint(new Coordinate(coordinates.get(0), coordinates.get(1)));
    }
    @Named("pointToList")
    default List<Double> pointToList(Point point) {
        if (point == null) return null;
        return List.of(point.getX(), point.getY()); // lon, lat
    }
}
