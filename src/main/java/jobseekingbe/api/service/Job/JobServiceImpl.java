package jobseekingbe.api.service.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jobseekingbe.api.builder.JobSearchBuilder;
import jobseekingbe.api.convert.JobSearchBuilderConverter;
import jobseekingbe.api.entity.Job;
import jobseekingbe.api.model.JobDTO;
import jobseekingbe.api.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	JobSearchBuilderConverter builderConverter;
	
	
	
	@Override
	public List<JobDTO> findJobs(Map<String, Object> params) {
		JobSearchBuilder jobBuilder=builderConverter.toJobSearchBuilderConverter(params);
		List<Job> listJObs= jobRepository.findJobs(jobBuilder);
		List<JobDTO> jobDTOs=new ArrayList<>();
		return jobDTOs;
	}

}
