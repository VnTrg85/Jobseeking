package jobseekingbe.api.service.Job;

import java.util.List;

import jobseekingbe.api.entity.Job;


public interface JobService {
    public List<Job> getJobs();
    public Job getJob(Long id);
    public String addJob(Job jobType);
    public String updateJob(Job jobType);
    public String updateStatus(Long id);
    public String deleteJob(Long id);
    public List<Job> getJobsByCompany(Long companyId);
}
