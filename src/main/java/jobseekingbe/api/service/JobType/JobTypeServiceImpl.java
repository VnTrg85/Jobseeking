package jobseekingbe.api.service.JobType;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jobseekingbe.api.entity.JobType;
import jobseekingbe.api.repository.JobTypeRepository;

@Service
public class JobTypeServiceImpl implements JobTypeService {
    
    @Autowired
    private JobTypeRepository jobTypeRepository;

    @Override
    public List<JobType> getAllJobTypes() {
        return jobTypeRepository.findAll();
    }

    @Override
    public JobType getJobTypeById(Long id) {
        return jobTypeRepository.findById(id).orElse(null);
    }

    @Override
    public JobType saveJobType(JobType jobType) {
        return jobTypeRepository.save(jobType);
    }

    @Override
    public void updateJobType(Long id, JobType jobType) {
        jobType.setId(id);
        jobTypeRepository.save(jobType);
    }

    @Override
    public void deleteJobType(Long id) {
        jobTypeRepository.deleteById(id);
    }
}
