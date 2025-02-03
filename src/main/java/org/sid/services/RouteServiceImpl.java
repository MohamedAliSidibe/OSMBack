package org.sid.services;

import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.sid.dto.RouteDTO;
import org.sid.entities.Route;
import org.sid.mapper.RouteMapper;
import org.sid.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService{
    private final GeometryFactory geometryFactory = new GeometryFactory();

    private final RouteMapper routeMapper;
    private final RouteRepository routeRepository;

    public RouteServiceImpl(RouteMapper routeMapper, RouteRepository routeRepository) {
        this.routeMapper = routeMapper;
        this.routeRepository = routeRepository;
    }

    @Override
    public Route createRoute(RouteDTO routeDTO) {
       Route route = routeMapper.toEntity(routeDTO);
        return routeRepository.save(route);
    }

    @Override
    public @NotNull(message = "La liste de chemin est obligatoire") LineString convertLineStringToList(LineString lineString) {
        if (lineString == null) return null;
        return (LineString) List.of(lineString.getCoordinates()).stream()
                .map(coord -> List.of(coord.getX(), coord.getY())) // lon, lat
                .collect(Collectors.toList());
    }


    @Override
    public LineString convertListToLineString(List<List<Double>> path) {
        if (path == null || path.isEmpty()) return null;
        Coordinate[] coordinates = path.stream()
                .map(coord -> new Coordinate(coord.get(0), coord.get(1)))
                .toArray(Coordinate[]::new);
        return geometryFactory.createLineString(coordinates);
    }
}
