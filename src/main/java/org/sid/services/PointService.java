package org.sid.services;

import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.Point;
import org.sid.dto.PointEntityDTO;
import org.sid.entities.PointEntity;

import java.util.List;

public interface PointService {
    PointEntity createPoint(PointEntityDTO  pointEntityDTO);
    @NotNull(message = "Les coordonnées sont obligatoires") Point convertPointToList(Point point);
    Point convertListToPoint(List<Double> coordinates);
}
