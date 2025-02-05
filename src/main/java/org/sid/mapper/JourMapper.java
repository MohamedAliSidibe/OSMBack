package org.sid.mapper;

import org.sid.dto.JourDTO;
import org.sid.entities.Jour;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = PointDetailMapper.class)
public interface JourMapper {
    GeometryFactory GEOMETRY_FACTORY = new GeometryFactory();

    @Mapping(target = "path", expression = "java(convertLineStringToList(jour.getPath()))")
    JourDTO toDto(Jour jour);

    @Mapping(target = "path", expression = "java(convertListToLineString(jourDTO.getPath()))")
    Jour toEntity(JourDTO jourDTO);

    List<JourDTO> toDtoList(List<Jour> jours);
    List<Jour> toEntityList(List<JourDTO> jours);

    // Conversion de LineString (PostGIS) vers List<List<Double>> pour JSON
    default List<List<Double>> convertLineStringToList(LineString lineString) {
        if (lineString == null) return List.of();
        return Arrays.stream(lineString.getCoordinates())
                .map(coord -> List.of(coord.x, coord.y))
                .collect(Collectors.toList());
    }

    // Conversion de List<List<Double>> (JSON) vers LineString (PostGIS)
    default LineString convertListToLineString(List<List<Double>> path) {
        if (path == null || path.isEmpty()) {
            return GEOMETRY_FACTORY.createLineString(new Coordinate[]{});
        }
        Coordinate[] coordinates = path.stream()
                .map(coord -> new Coordinate(coord.get(0), coord.get(1)))
                .toArray(Coordinate[]::new);
        return GEOMETRY_FACTORY.createLineString(coordinates);
    }
}
