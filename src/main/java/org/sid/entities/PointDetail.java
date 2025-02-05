package org.sid.entities;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point coordinates;

    private String photoQuery;
    private String arrivalTime;
    private String departureTime;

    @Column(length = 1000) // Permet d'avoir une description plus longue
    private String description;
}
