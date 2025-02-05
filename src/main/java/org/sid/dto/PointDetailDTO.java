package org.sid.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointDetailDTO {
    private String name;
    private List<Double> coordinates;
    private String photoQuery;
    private String arrivalTime;
    private String departureTime;
    private String description;
}
