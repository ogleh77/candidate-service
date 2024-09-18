package org.ogleh.candinatesservices.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candidateID;
    private String fullName;
    private String nickName;
    private String gender;
    private boolean electedBefore;
    private String profilePictureURL;
    @OneToOne(fetch = FetchType.LAZY)
    private Party party;
    @OneToMany
    private Set<Objectives> objectives;
}
