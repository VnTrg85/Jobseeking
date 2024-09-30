package jobseekingbe.api.service.Job;

import java.util.List;
import java.util.Map;

import jobseekingbe.api.entity.Job;
import jobseekingbe.api.model.JobDTO;

public interface JobService {
	List<JobDTO> findJobs(Map<String, Object> params);
}
