package org.ogleh.candinatesservices.data.response;

import lombok.Builder;

@Builder
public record PartyDTO(int partyId,
                       String partyName,
                       String partyDescription,
                       String partyProfile,
                       CandidateDTO candidateDTO) {
}
