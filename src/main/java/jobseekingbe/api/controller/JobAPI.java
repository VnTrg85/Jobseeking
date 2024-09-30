package jobseekingbe.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jobseekingbe.api.model.JobDTO;
import jobseekingbe.api.service.Job.JobService;


@RestController
public class JobAPI {

	@Autowired
	private JobService jobService;
	@GetMapping(value = "/api/job")
	public List<JobDTO> getJob(@RequestParam Map<String, Object> params){
		List<JobDTO> jobList= jobService.findJobs(params);
		return jobList;
	}
}
