package org.sid.services;

import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.LineString;
import org.sid.dto.RouteDTO;
import org.sid.entities.Route;

import java.util.List;

public interface RouteService {
    Route createRoute(RouteDTO routeDTO);
    @NotNull(message = "La liste de chemin est obligatoire") LineString convertLineStringToList(LineString lineString);
    LineString convertListToLineString(List<List<Double>> path);
}
