package org.ogleh.candinatesservices.data.mappers;

import org.ogleh.candinatesservices.data.requests.PartyDao;
import org.ogleh.candinatesservices.data.response.PartyDTO;
import org.ogleh.candinatesservices.models.entities.Party;

public class PartyMapper {

    public static PartyDTO partyToPartyDto(Party party) {
        return PartyDTO.builder()
                .partyId(party.getPartyId())
                .partyDescription(party.getPartyDescription())
                .partyName(party.getPartyName())
                .partyProfile(party.getPartyProfile())
//                .candidateDTO(CandidateMapper.candidateToCandidateDto(party.getCandidate()))
                .build();
    }


    public static Party partyDapToParty(PartyDao partyDao) {
        return Party.builder()
                .partyProfile(partyDao.partyProfile())
                .partyDescription(partyDao.partyDescription())
                .partyName(partyDao.partyName())

                .build();
    }
}
