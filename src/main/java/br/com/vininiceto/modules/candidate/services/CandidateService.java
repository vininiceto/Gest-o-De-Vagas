package br.com.vininiceto.modules.candidate.services;

import br.com.vininiceto.exceptions.UserFoundException;
import br.com.vininiceto.modules.candidate.Repository.CandidateRepository;
import br.com.vininiceto.modules.candidate.entities.CandidateEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    private CandidateRepository repository;

    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.repository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail()).ifPresent((user) -> {
            throw new UserFoundException();
        });


        return this.repository.save(candidateEntity);
    }



}
