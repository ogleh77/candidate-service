package org.ogleh.candinatesservices.data.requests;

import lombok.Builder;
import org.ogleh.candinatesservices.models.entities.Objectives;

import java.util.Set;
@Builder
public record CandidateDao(
        String fullName,
        String nickName,
        String gender,
        boolean electedBefore,
        String profilePictureURL,
        int partyID,
        Set<Objectives> objectives) {
}
