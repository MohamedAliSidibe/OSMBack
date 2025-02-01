package org.sid.services;

import org.sid.dto.RouteDTO;
import org.sid.entities.Route;

public interface RouteService {
    Route createRoute(RouteDTO routeDTO);
}
