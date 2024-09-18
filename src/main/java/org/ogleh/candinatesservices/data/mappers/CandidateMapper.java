package org.ogleh.candinatesservices.data.mappers;

import org.ogleh.candinatesservices.data.requests.CandidateDao;
import org.ogleh.candinatesservices.data.response.CandidateDTO;
import org.ogleh.candinatesservices.models.entities.Candidate;

public class CandidateMapper {

    public static CandidateDTO candidateToCandidateDto(Candidate candidate) {
        return CandidateDTO.builder()
                .electedBefore(candidate.isElectedBefore())
                .candidateID(candidate.getCandidateID())
                .fullName(candidate.getFullName())
                .gender(candidate.getGender())
                .profilePictureURL(candidate.getProfilePictureURL())
                .objectives(candidate.getObjectives())
                .nickName(candidate.getNickName())
                .PartyDto(PartyMapper.partyToPartyDto(candidate.getParty()))
                .build();
    }

    public static Candidate candidateDaoToCandidate(CandidateDao candidateDao) {
        return Candidate.builder()
                .electedBefore(candidateDao.electedBefore())
                .fullName(candidateDao.fullName())
                .gender(candidateDao.gender())
                .profilePictureURL(candidateDao.profilePictureURL())
                .objectives(candidateDao.objectives())
                .nickName(candidateDao.nickName())
                .build();
    }
}
