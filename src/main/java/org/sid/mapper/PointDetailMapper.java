package org.sid.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sid.dto.PointDetailDTO;
import org.sid.entities.PointDetail;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PointDetailMapper {
    GeometryFactory GEOMETRY_FACTORY = new GeometryFactory();

    @Mapping(target = "coordinates", expression = "java(convertPointToList(pointDetail.getCoordinates()))")
    PointDetailDTO toDto(PointDetail pointDetail);

    @Mapping(target = "coordinates", expression = "java(convertListToPoint(pointDetailDTO.getCoordinates()))")
    PointDetail toEntity(PointDetailDTO pointDetailDTO);

    default List<Double> convertPointToList(Point point) {
        if (point == null) return List.of(0.0, 0.0);
        return List.of(point.getX(), point.getY());
    }

    default Point convertListToPoint(List<Double> coordinates) {
        if (coordinates == null || coordinates.size() != 2) {
            return GEOMETRY_FACTORY.createPoint(new Coordinate(0.0, 0.0));
        }
        return GEOMETRY_FACTORY.createPoint(new Coordinate(coordinates.get(0), coordinates.get(1)));
    }
}
