package org.sid.web;

import org.sid.dto.VoyageDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/voyages")
public interface VoyageController {
    @GetMapping("/All")
    List<VoyageDTO> getAllVoyages();
    @PostMapping("/add")
    VoyageDTO createVoyage(@RequestBody VoyageDTO voyageDTO);
}
