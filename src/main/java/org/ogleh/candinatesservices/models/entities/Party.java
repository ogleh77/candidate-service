package org.ogleh.candinatesservices.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "party_id_seq")
    @SequenceGenerator(name = "party_id_seq", sequenceName = "party_id_seq")
    private int partyId;
    private String partyName;
    private String partyDescription;
    private String partyProfile;
    @OneToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "candidateId")
    private Candidate candidate;
}
