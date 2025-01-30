package org.sid.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    private List<List<Double>> path;
    @NotNull(message = "Le jour est obligatoire")
    private Long jourId;
}
