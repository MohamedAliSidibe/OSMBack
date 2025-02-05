package org.sid.services.web;

import org.sid.dto.VoyageDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/voyage")
public interface VoyageController {
    @GetMapping("/all")
    List<VoyageDTO> getAllVoyages();
    @PostMapping("/add")
    VoyageDTO createVoyage(@RequestBody VoyageDTO voyageDTO);
}
