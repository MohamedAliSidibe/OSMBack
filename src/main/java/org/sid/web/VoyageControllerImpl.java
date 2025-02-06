package org.sid.web;

import org.sid.dto.VoyageDTO;
import org.sid.services.VoyageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class VoyageControllerImpl implements VoyageController{
    private final VoyageService voyageService;

    public VoyageControllerImpl(VoyageService voyageService) {
        this.voyageService = voyageService;
    }

    @Override
    public List<VoyageDTO> getAllVoyages() {
        System.out.println("momo");
        return voyageService.getAllVoyages();
    }

    @Override
    public VoyageDTO createVoyage(VoyageDTO voyageDTO) {
        return voyageService.saveVoyage(voyageDTO);
    }
}
