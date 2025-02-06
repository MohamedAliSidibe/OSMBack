package org.sid.repository;

import org.sid.entities.Jour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JourRepository extends JpaRepository<Jour, Long> {
}
