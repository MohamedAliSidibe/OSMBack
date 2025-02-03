package org.sid.web;

import org.sid.dto.VoyageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/voyage")
public interface VoyageRestController {
    @GetMapping("/All")
    List<VoyageDTO> getAllVoyages();
    @GetMapping("/{id}")
    VoyageDTO getVoyageById(@PathVariable Long id);
    @PostMapping("/add")
    ResponseEntity<VoyageDTO> createVoyage(@RequestBody VoyageDTO voyageDTO);
}
