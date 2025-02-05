package org.sid.entities;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.LineString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int day;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PointDetail> points;

    private String mode;

    @Column(columnDefinition = "geometry(LineString, 4326)")
    private LineString path;
}
