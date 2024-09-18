package org.ogleh.candinatesservices.data.response;

import lombok.Builder;
import org.ogleh.candinatesservices.models.entities.Objectives;

import java.util.Set;

@Builder
public record CandidateDTO(
        Integer candidateID,
        String fullName,
        String nickName,
        String gender,
        boolean electedBefore,
        String profilePictureURL,
        PartyDTO PartyDto,
        Set<Objectives> objectives
) {
}
