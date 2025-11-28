package br.com.vininiceto.modules.candidate.Repository;

import br.com.vininiceto.modules.candidate.entities.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {

    Optional<CandidateEntity> findByEmail(String email);

    Optional<CandidateEntity> findByusername(String username);


}
