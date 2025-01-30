package org.sid.mapper;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.sid.dto.RouteDTO;
import org.sid.entities.Route;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RouteMapper {
    RouteMapper INSTANCE = Mappers.getMapper(RouteMapper.class);
    GeometryFactory geometryFactory = new GeometryFactory();
    @Mapping(source = "path", target = "path", qualifiedByName = "listToLineString")
    Route toEntity(RouteDTO routeDTO);
    @Mapping(source = "path", target = "path", qualifiedByName = "lineStringToList")
    RouteDTO toDTO(Route route);

    @Named("listToLineString")
    default LineString listToLineString(List<List<Double>> path) {
        if (path == null || path.isEmpty()) return null;
        Coordinate[] coordinates = path.stream()
                .map(coord -> new Coordinate(coord.get(0), coord.get(1)))
                .toArray(Coordinate[]::new);
        return geometryFactory.createLineString(coordinates);
    }

    @Named("lineStringToList")
    default List<List<Double>> lineStringToList(LineString lineString) {
        if (lineString == null) return null;
        return List.of(lineString.getCoordinates()).stream()
                .map(coord -> List.of(coord.getX(), coord.getY())) // lon, lat
                .collect(Collectors.toList());
    }
}
