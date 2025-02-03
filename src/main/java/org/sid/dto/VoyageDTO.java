package org.sid.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoyageDTO {
    private long id;
    @NotBlank(message = "Le nom est obligatoire")
    private String name;
    private List<JourDTO> jours;
}
