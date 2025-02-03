package org.sid.services.impl;

import org.sid.dto.VoyageDTO;
import org.sid.dto.RouteDTO;
import org.sid.entities.Voyage;
import org.sid.repository.VoyageRepository;
import org.sid.services.VoyageService;
import org.sid.services.PointService;
import org.sid.services.RouteService;
import org.sid.mapper.VoyageMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoyageServiceImpl implements VoyageService {
    private final VoyageRepository voyageRepository;
    private final VoyageMapper voyageMapper;
    private final PointService pointService;
    private final RouteService routeService;

    public VoyageServiceImpl(VoyageRepository voyageRepository, VoyageMapper voyageMapper,
                             PointService pointService, RouteService routeService) {
        this.voyageRepository = voyageRepository;
        this.voyageMapper = voyageMapper;
        this.pointService = pointService;
        this.routeService = routeService;
    }

    @Override
    public List<VoyageDTO> getAllVoyages() {
        List<VoyageDTO> voyages = voyageRepository.findAll().stream()
                .map(voyageMapper::toDTO)
                .collect(Collectors.toList());

        // 🔥 Convertir les points et routes pour respecter le format JSON demandé
        voyages.forEach(voyage -> voyage.getJours().forEach(jour -> {
            // Conversion des points en [lon, lat]
            jour.setPoints(jour.getPoints().stream().map(point -> {
                point.setCoordinates(pointService.convertPointToList(point.getCoordinates()));
                return point;
            }).collect(Collectors.toList()));

            // Conversion des routes en [[lon, lat], [lon, lat]]
            RouteDTO route = jour.getRoute();
            if (route != null) {
                route.setPath(routeService.convertLineStringToList(route.getPath()));
            }
        }));

        return voyages;
    }

    @Override
    public VoyageDTO getVoyageById(Long id) {
        VoyageDTO voyage = voyageMapper.toDTO(voyageRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Voyage non trouvé")));

        // 🔥 Convertir les points et routes pour respecter le format JSON demandé
        voyage.getJours().forEach(jour -> {
            jour.setPoints(jour.getPoints().stream().map(point -> {
                point.setCoordinates(pointService.convertPointToList(point.getCoordinates()));
                return point;
            }).collect(Collectors.toList()));

            RouteDTO route = jour.getRoute();
            if (route != null) {
                route.setPath(routeService.convertLineStringToList(route.getPath()));
            }
        });

        return voyage;
    }

    @Override
    public VoyageDTO addVoyage(VoyageDTO voyageDTO) {
        // 🔥 Convertir `List<Double>` -> `Point` et `List<List<Double>>` -> `LineString` avant sauvegarde
        voyageDTO.getJours().forEach(jour -> {
            jour.setPoints(jour.getPoints().stream().map(point -> {
                point.setCoordinates(pointService.convertListToPoint((List<Double>) point.getCoordinates()));
                return point;
            }).collect(Collectors.toList()));

            RouteDTO route = jour.getRoute();
            if (route != null) {
                route.setPath(routeService.convertListToLineString((List<List<Double>>) route.getPath()));
            }
        });

        Voyage voyage = voyageMapper.toEntity(voyageDTO);
        Voyage savedVoyage = voyageRepository.save(voyage);

        return voyageMapper.toDTO(savedVoyage);
    }
}
