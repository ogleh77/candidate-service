package org.ogleh.candinatesservices.services;

import lombok.RequiredArgsConstructor;
import org.ogleh.candinatesservices.data.mappers.CandidateMapper;
import org.ogleh.candinatesservices.data.requests.CandidateDao;
import org.ogleh.candinatesservices.data.response.CandidateDTO;
import org.ogleh.candinatesservices.models.entities.Candidate;
import org.ogleh.candinatesservices.models.entities.Party;
import org.ogleh.candinatesservices.models.repo.CandidateRepository;
import org.ogleh.candinatesservices.models.repo.PartyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;
    private final PartyRepository partyRepository;

    @Transactional
    public HttpStatus createCandidate(CandidateDao candidateDao) {

        Candidate candidate = CandidateMapper.candidateDaoToCandidate(candidateDao);

        checkIfPartyExists(candidateDao.partyID(), candidate);
        candidateRepository.save(candidate);

        return HttpStatus.CREATED;
    }

    @Transactional
    public HttpStatus updateCandidate(int candidateId, CandidateDao candidateDao) {
        Optional<Candidate> findCandidate = candidateRepository.findById(candidateId);

        if (findCandidate.isPresent()) {
            Candidate updateCandidate = CandidateMapper.candidateDaoToCandidate(candidateDao);

            checkIfPartyExists(candidateDao.partyID(), updateCandidate);

            updateCandidate.setCandidateID(candidateId);

            candidateRepository.save(updateCandidate);
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_FOUND;
    }

    // TODO: 14/09/24 Insha Allah ku dar sawirda oo file lagu save greeyo iyo global exception insha Allah  

    public HttpStatus deleteCandidate(int candidateId) {
        Optional<Candidate> candidate = candidateRepository.findById(candidateId);
        if (candidate.isPresent()) {
            candidateRepository.delete(candidate.get());
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_FOUND;
    }

    public Stream<CandidateDTO> getAllCandidates() {
        return candidateRepository
                .findAll().stream().map(CandidateMapper::candidateToCandidateDto);
    }


    private void checkIfPartyExists(int partyID, Candidate candidate) {
        Optional<Party> findParty = partyRepository.findById(partyID);
        if (findParty.isPresent()) {
            Party party = findParty.get();
            candidate.setParty(party);
            party.setCandidate(candidate);
            partyRepository.save(party);
        }
    }
}
