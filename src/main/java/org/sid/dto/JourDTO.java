package org.sid.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JourDTO {
    private int day;
    private List<PointDetailDTO> points;
    private String mode;
    private List<List<Double>> path;
}
