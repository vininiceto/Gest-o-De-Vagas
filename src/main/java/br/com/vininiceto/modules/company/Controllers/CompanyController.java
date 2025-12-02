package br.com.vininiceto.modules.company.Controllers;

import br.com.vininiceto.exceptions.UserFoundException;
import br.com.vininiceto.modules.company.Services.CompanyService;
import br.com.vininiceto.modules.company.entities.CompanyEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/register")
    public ResponseEntity<Object> createCompany(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            var result = this.companyService.execute(companyEntity);
            return ResponseEntity.ok().body(companyService.execute(result));
        } catch (UserFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
