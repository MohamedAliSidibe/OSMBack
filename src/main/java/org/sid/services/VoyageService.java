package org.sid.services;

import org.sid.dto.VoyageDTO;

import java.util.List;

public interface VoyageService {
    List<VoyageDTO> getAllVoyages();
    VoyageDTO getVoyageById(Long id);
    VoyageDTO addVoyage(VoyageDTO voyageDTO);

}
