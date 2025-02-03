package org.sid.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.locationtech.jts.geom.Point;
import org.sid.entities.Jour;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PointEntityDTO {
    private Long id;
    @NotBlank(message = "Le name est obligatoire")
    private String name;
    @NotNull(message = "Les coordonnées sont obligatoires")
    private Point coordinates;
    @NotBlank(message = "Le nom de la photo est obligatoire")
    private String photoQuery;
    @NotBlank(message = "L'heure d'arrivée est obligatoire")
    private String arrivalTime;
    @NotBlank(message = "L'heure de départ est obligatoire")
    private String departureTime;
    @NotBlank(message = "La description est obligatoire")
    private String description;
    @NotNull(message = "Le jour est obligatoire")
    private Jour jour;
}
