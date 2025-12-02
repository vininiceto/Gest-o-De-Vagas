package br.com.vininiceto.modules.company.Services;

import br.com.vininiceto.exceptions.UserFoundException;
import br.com.vininiceto.modules.company.Repository.CompanyRepository;
import br.com.vininiceto.modules.company.entities.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;


    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.repository.findCompanyByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail()).ifPresent((user) -> {
            throw new UserFoundException();
        });

        return this.repository.save(companyEntity);
    }


}
