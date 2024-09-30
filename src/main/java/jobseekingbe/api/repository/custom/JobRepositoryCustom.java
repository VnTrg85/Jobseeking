package jobseekingbe.api.repository.custom;

import java.util.List;

import jobseekingbe.api.builder.JobSearchBuilder;
import jobseekingbe.api.entity.Job;
import jobseekingbe.api.model.JobDTO;

public interface JobRepositoryCustom {
	List<Job> findJobs(JobSearchBuilder builder);
}
