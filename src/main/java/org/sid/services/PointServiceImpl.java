package org.sid.services;

import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.sid.dto.PointEntityDTO;
import org.sid.entities.PointEntity;
import org.sid.mapper.PointMapper;
import org.sid.repository.PointRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointServiceImpl implements PointService{
    private final GeometryFactory geometryFactory = new GeometryFactory();

   private final PointMapper pointMapper;
    private final PointRepository pointRepository;

    public PointServiceImpl(PointMapper pointMapper, PointRepository pointRepository) {
        this.pointMapper = pointMapper;
        this.pointRepository = pointRepository;
    }


    @Override
    public PointEntity createPoint(PointEntityDTO pointEntityDTO) {

        PointEntity pointEntity= pointMapper.toEntity(pointEntityDTO);
        pointRepository.save(pointEntity);
        return pointEntity;

    }

    @Override
    public @NotNull(message = "Les coordonnées sont obligatoires") Point convertPointToList(Point point) {
        if (point == null) return null;
        return (Point) List.of(point.getX(), point.getY());
    }

    @Override
    public Point convertListToPoint(List<Double> coordinates) {
        if (coordinates == null || coordinates.size() < 2) return null;
        return geometryFactory.createPoint(new Coordinate(coordinates.get(0), coordinates.get(1)));
    }

}
