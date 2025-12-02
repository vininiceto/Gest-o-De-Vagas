package br.com.vininiceto.modules.company.Repository;

import br.com.vininiceto.modules.company.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    Optional<CompanyEntity> findCompanyByUsernameOrEmail(String username, String email);


}
