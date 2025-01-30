package org.sid.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int day;
    @ManyToOne
    @JoinColumn(name = "voyage_id")
    private Voyage voyage;
    @OneToMany(mappedBy = "jour", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PointEntity> points;
    @OneToOne(cascade = CascadeType.ALL)
    private Route routes;
}
