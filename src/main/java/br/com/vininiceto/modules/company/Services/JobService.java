package br.com.vininiceto.modules.company.Services;

import br.com.vininiceto.modules.company.Repository.JobRepository;
import br.com.vininiceto.modules.company.entities.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public JobEntity createJob(JobEntity jobEntity) {
        return this.repository.save(jobEntity);
    }


}
