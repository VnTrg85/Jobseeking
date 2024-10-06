package jobseekingbe.api.service.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jobseekingbe.api.entity.Job;
import jobseekingbe.api.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Override
    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJob(Long id) {
        return jobRepository.findById(id).get();
    }

    @Override
    public String addJob(Job job) {
        try {
            jobRepository.save(job);
            return "Added";
        } catch (Exception e) {
            return "Failed to add job";
        }
    }

    @Override
    public String updateJob(Job job) {
        try {
            jobRepository.save(job);
            return "Updated";
        } catch (Exception e) {
            return "Failed to update job";
        }
    }

    @Override
    public String deleteJob(Long id) {
        try {
            jobRepository.deleteById(id);
            return "Deleted";
        } catch (Exception e) {
            return "Failed to delete job";
        }
    }

    @Override
    public List<Job> getJobsByCompany(Long companyId) {
        List<Job> jobs = jobRepository.findAll();
        List<Job> jobsByCompany = new ArrayList<Job>();

        for (Job job : jobs) {
            if(job.getCompany().getId() == companyId) {
                jobsByCompany.add(job);
            }
        }
        return jobsByCompany;
    }

    @Override
    public String updateStatus(Long id) {
        Job job = jobRepository.findById(id).get();
        try {
            if(job.getStatus().equals( "rescruiting")) {
                job.setStatus("lock");
            }else {
                job.setStatus("rescruiting");
            }
        jobRepository.save(job);
            return "Update Status Success";
        } catch (Exception e) {
            return "Update status failed";
        }
    }

}
