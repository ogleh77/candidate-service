package org.ogleh.candinatesservices.data.requests;

public record PartyDao(String partyName,
                       String partyDescription,
                       String partyProfile,
                       int candidateId) {
}
