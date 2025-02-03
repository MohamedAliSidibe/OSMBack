package org.sid.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.locationtech.jts.geom.LineString;
import org.sid.entities.Jour;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RouteDTO {
    private Long id;
    @NotBlank(message = "Le mode est obligatoire")
    private String mode;
    @NotNull(message = "La liste de chemin est obligatoire")
    private LineString path;
    @NotNull(message = "Le jour est obligatoire")
    private Jour jour;
}
