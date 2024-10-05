package jobseekingbe.api.service.JobType;

import java.util.List;

import jobseekingbe.api.entity.JobType;

public interface JobTypeService {
    List<JobType> getAllJobTypes();
    JobType getJobTypeById(Long id);
    JobType saveJobType(JobType jobType);
    void updateJobType(Long id, JobType jobType);
    void deleteJobType(Long id);
}
