package org.sid.web;

import org.sid.dto.VoyageDTO;
import org.sid.services.VoyageService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class VoyageRestControllerImpl implements VoyageRestController{
    private final VoyageService voyageService;

    public VoyageRestControllerImpl(VoyageService voyageService) {
        this.voyageService = voyageService;
    }

    @Override
    public List<VoyageDTO> getAllVoyages() {
        return voyageService.getAllVoyages();
    }

    @Override
    public VoyageDTO getVoyageById(Long id) {
        return voyageService.getVoyageById(id);
    }

    @Override
    public ResponseEntity<VoyageDTO> createVoyage(VoyageDTO voyageDTO) {
        VoyageDTO savedVoyage = voyageService.addVoyage(voyageDTO);
        return ResponseEntity.ok(savedVoyage);
    }
}
