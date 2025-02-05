package org.sid.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoyageDTO {
    private String id;
    private String name;
    private List<JourDTO> jours;
}
