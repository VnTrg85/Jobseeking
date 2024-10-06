package jobseekingbe.api.service.JobStatus;

import java.util.List;
import java.util.Optional;

import jobseekingbe.api.entity.JobStatus;

public interface JobStatusService {
    public List<JobStatus> getJobStatus();
    public Optional<JobStatus> getJobStatus(Long id);
    public String addJobStatus(JobStatus jobStatus);
    public String updateJobStatus(JobStatus jobStatus);
    public String deleteJobStatus(Long id);
}
