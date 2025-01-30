package org.sid.entities;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.LineString;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mode;
    @Column(columnDefinition = "geometry(LineString,4326)")
    private LineString path;
    @OneToOne(mappedBy = "routes", cascade = CascadeType.ALL)
    private Jour jour;
}
