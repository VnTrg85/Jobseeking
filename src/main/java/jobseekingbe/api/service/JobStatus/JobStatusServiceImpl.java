package jobseekingbe.api.service.JobStatus;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jobseekingbe.api.entity.JobStatus;
import jobseekingbe.api.repository.JobStatusRepository;

@Service
public class JobStatusServiceImpl implements JobStatusService {

    @Autowired
    private JobStatusRepository jobStatusRepository;
    @Override
    public List<JobStatus> getJobStatus() {
        return jobStatusRepository.findAll();
    }

    @Override
    public Optional<JobStatus> getJobStatus(Long id) {
        return jobStatusRepository.findById(id);
    }

    @Override
    public String addJobStatus(JobStatus jobStatus) {
        try {
            jobStatusRepository.save(jobStatus);
            return "Added";
        } catch (Exception e) {
            return "Failed to add job status";
        }
    }

    @Override
    public String updateJobStatus(JobStatus jobStatus) {
        try {
            jobStatusRepository.save(jobStatus);
            return "Updated";
        } catch (Exception e) {
            return "Failed to update job status";
        }
    }

    @Override
    public String deleteJobStatus(Long id) {
        try {
            jobStatusRepository.deleteById(id);
            return "Deleted";
        } catch (Exception e) {
            return "Failed to delete job status";
        }
    }

}
