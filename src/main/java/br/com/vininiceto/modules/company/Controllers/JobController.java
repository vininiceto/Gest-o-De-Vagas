package br.com.vininiceto.modules.company.Controllers;

import br.com.vininiceto.modules.company.Services.JobService;
import br.com.vininiceto.modules.company.entities.JobEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/create")
    public JobEntity createJob(@Valid @RequestBody JobEntity jobEntity){
        return this.jobService.createJob(jobEntity);
    }

}
