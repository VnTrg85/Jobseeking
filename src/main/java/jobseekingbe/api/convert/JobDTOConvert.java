package jobseekingbe.api.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jobseekingbe.api.entity.Job;
import jobseekingbe.api.model.JobDTO;

@Component
public class JobDTOConvert {

	@Autowired
	private ModelMapper modelMapper;
	public JobDTO convertToJobDTO(Job item) {
		JobDTO dto= modelMapper.map(item	, JobDTO.class);
		return dto;
	}
}
