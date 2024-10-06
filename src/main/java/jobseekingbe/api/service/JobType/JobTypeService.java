package jobseekingbe.api.service.JobType;

import java.util.List;
import java.util.Optional;

import jobseekingbe.api.entity.JobType;


public interface JobTypeService {
    public List<JobType> getJobTypes();
    public Optional<JobType> getJobType(Long id);
    public JobType addJobType(JobType job);
    public void updateJobType(Long id, JobType jobType);
    public void deleteJobType(Long id);
}
