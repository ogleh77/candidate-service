package org.ogleh.candinatesservices.controllers;

import lombok.RequiredArgsConstructor;
import org.ogleh.candinatesservices.data.requests.PartyDao;
import org.ogleh.candinatesservices.data.response.PartyDTO;
import org.ogleh.candinatesservices.services.PartyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/party")
public class PartyController {
    private final PartyService partyService;

    @PostMapping("/create")
    public PartyDTO partyDTO(@RequestBody PartyDao partyDao) {
        return partyService.create(partyDao);
    }

    @GetMapping("/{partyId}")
    public PartyDTO getParty(@PathVariable int partyId) {
        return partyService.getParty(partyId);
    }

    @PutMapping("/update/{partyId}")
    public PartyDTO updateParty(@PathVariable int partyId, @RequestBody PartyDao partyDao) {
        return partyService.update(partyId, partyDao);
    }

    @GetMapping("/")
    public Stream<PartyDTO> getAllParties() {
        return partyService.getAllParties();
    }
}
