package org.sid.services;

import org.sid.dto.PointEntityDTO;
import org.sid.entities.PointEntity;

public interface PointService {
    PointEntity createPoint(PointEntityDTO  pointEntityDTO);
}
