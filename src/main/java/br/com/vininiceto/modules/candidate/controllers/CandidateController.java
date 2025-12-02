package br.com.vininiceto.modules.candidate.controllers;

import br.com.vininiceto.exceptions.UserFoundException;
import br.com.vininiceto.modules.candidate.Repository.CandidateRepository;
import br.com.vininiceto.modules.candidate.entities.CandidateEntity;
import br.com.vininiceto.modules.candidate.services.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository repository;
    @Autowired
    private CandidateService service;


    @PostMapping("/register")
    public ResponseEntity<Object> registerCandidate(@Valid @RequestBody CandidateEntity candidateEntity) {
       try {
           return ResponseEntity.ok().body(service.execute(candidateEntity));
       } catch(Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<CandidateEntity>> getCandidate(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(repository.findById(id));
    }

    @GetMapping("/users/")
    public ResponseEntity<List<CandidateEntity>> getAllCandidates() {
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @GetMapping("/users/email/{email}")
    public ResponseEntity<Optional<CandidateEntity>> getCandidateByEmail(@PathVariable String email) {
        return ResponseEntity.status(200).body(Optional.ofNullable(repository.findByEmail(email).orElseThrow(() -> new RuntimeException("Email não encontrado"))));
    }

    @GetMapping("/users/username/{username}")
    public ResponseEntity<Optional<CandidateEntity>> getCandidateByUserName(@PathVariable String username) {
        return ResponseEntity.status(200).body(Optional.ofNullable(repository.findByUsername(username).orElseThrow(() -> new RuntimeException("username não cadastrado!"))));
    }
}

