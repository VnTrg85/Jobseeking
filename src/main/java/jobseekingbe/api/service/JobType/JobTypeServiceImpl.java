package jobseekingbe.api.service.JobType;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jobseekingbe.api.entity.JobType;
import jobseekingbe.api.repository.JobTypeRepository;

@Service
public class JobTypeServiceImpl  implements JobTypeService{
    @Autowired
    private JobTypeRepository jobTypeRepository;
    @Override
    public List<JobType> getJobTypes() {
        return jobTypeRepository.findAll();
    }

    @Override
    public Optional<JobType> getJobType(Long id) {
        return jobTypeRepository.findById(id);
    }

    @Override
    public JobType addJobType(JobType jobType) {
        try {
            return jobTypeRepository.save(jobType);
        } catch (Exception e) {
            return null;
        }
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
