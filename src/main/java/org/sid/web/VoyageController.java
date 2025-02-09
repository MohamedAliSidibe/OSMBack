package org.sid.web;

import org.sid.dto.VoyageDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/voyages")
public interface VoyageController {
    @GetMapping
    List<VoyageDTO> getAllVoyages();
    @PostMapping
    VoyageDTO createVoyage(@RequestBody VoyageDTO voyageDTO);
}
