package org.ogleh.candinatesservices.services;

import lombok.RequiredArgsConstructor;
import org.ogleh.candinatesservices.data.mappers.PartyMapper;
import org.ogleh.candinatesservices.data.requests.PartyDao;
import org.ogleh.candinatesservices.data.response.PartyDTO;
import org.ogleh.candinatesservices.models.entities.Party;
import org.ogleh.candinatesservices.models.repo.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PartyService {
    private final PartyRepository partyRepository;

    public PartyDTO create(PartyDao partyDao) {
        Party party = PartyMapper.partyDapToParty(partyDao);
        partyRepository.save(party);
        return PartyMapper.partyToPartyDto(party);
    }


    public PartyDTO getParty(int partyId) {
        Optional<Party> party = partyRepository.findById(partyId);
        return party.map(PartyMapper::partyToPartyDto).orElse(null);
    }

    public PartyDTO update(int partyId, PartyDao partyDao) {
        Optional<Party> party = partyRepository.findById(partyId);
        if (party.isPresent()) {
            Party updatedParty = PartyMapper.partyDapToParty(partyDao);
            updatedParty.setPartyId(partyId);
            partyRepository.save(updatedParty);
            return PartyMapper.partyToPartyDto(updatedParty);
        }
        return null;
    }

    public Stream<PartyDTO> getAllParties() {
        return partyRepository.findAll().stream().map(PartyMapper::partyToPartyDto);
    }
}
