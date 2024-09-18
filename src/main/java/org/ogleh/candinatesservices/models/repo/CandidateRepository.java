package org.ogleh.candinatesservices.models.repo;

import org.ogleh.candinatesservices.models.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
}
