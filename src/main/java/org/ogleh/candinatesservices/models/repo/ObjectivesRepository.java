package org.ogleh.candinatesservices.models.repo;

import org.ogleh.candinatesservices.models.entities.Objectives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectivesRepository extends JpaRepository<Objectives, Integer> {
}
