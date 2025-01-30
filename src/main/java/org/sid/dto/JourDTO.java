package org.sid.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JourDTO {
    private Long id;
    @NotNull(message = "Le voyage est obligatoire")
    private VoyageDTO voyage;
    @NotNull(message = "La route est obligatoire")
    private RouteDTO route;
}
