package org.ogleh.candinatesservices.controllers;

import lombok.RequiredArgsConstructor;
import org.ogleh.candinatesservices.data.requests.CandidateDao;
import org.ogleh.candinatesservices.data.response.CandidateDTO;
import org.ogleh.candinatesservices.services.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/candidate")
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping("/add")
    public HttpStatus createCandidate(@RequestBody CandidateDao candidateDao) {
        return candidateService.createCandidate(candidateDao);
    }

    @PutMapping("/update/{candidateId}")
    public HttpStatus updateCandidate(@PathVariable int candidateId, @RequestBody CandidateDao candidateDao) {
        return candidateService.updateCandidate(candidateId, candidateDao);
    }

    @DeleteMapping("/delete/{candidateId}")
    public HttpStatus deleteCandidate(@PathVariable int candidateId) {
        return candidateService.deleteCandidate(candidateId);
    }

    @GetMapping("/")
    public Stream<CandidateDTO> candidates() {
        return candidateService.getAllCandidates();
    }
}
