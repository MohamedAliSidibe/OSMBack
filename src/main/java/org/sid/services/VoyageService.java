package org.sid.services;


import org.sid.dto.VoyageDTO;

import java.util.List;

public interface VoyageService {
    List<VoyageDTO> getAllVoyages();
    VoyageDTO saveVoyage(VoyageDTO voyageDTO);

}
