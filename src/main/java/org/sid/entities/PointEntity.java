package org.sid.entities;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PointEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "geometry(Point,4326)")
    private Point coordinates;
    private String photoQuery;
    private String arrivalTime;
    private String departureTime;
    @Column(length = 1000)
    private String description;
    @ManyToOne
    @JoinColumn(name = "jour_id")
    private Jour jour;
}
