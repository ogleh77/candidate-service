package org.ogleh.candinatesservices.models.repo;

import org.ogleh.candinatesservices.models.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
}
