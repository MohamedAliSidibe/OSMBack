package org.sid.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.sid.entities.Voyage;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JourDTO {
    private Long id;
    private int day;
    @NotNull(message = "Le voyage est obligatoire")
    private Voyage voyage;
    private List<PointEntityDTO> points;
    @NotNull(message = "La route est obligatoire")
    private RouteDTO route;
}
