package jobseekingbe.api.convert;

import java.util.Map;

import org.springframework.stereotype.Component;

import jobseekingbe.api.builder.JobSearchBuilder;
import jobseekingbe.api.utils.MapUtil;

@Component
public class JobSearchBuilderConverter {
	public JobSearchBuilder toJobSearchBuilderConverter(Map<String,Object> params) {
		JobSearchBuilder builder=new JobSearchBuilder.Builder()
															.setTitle(MapUtil.getJob(params, "title", String.class))
															.setLocation(MapUtil.getJob(params, "location", String.class))
															.setIndustry(MapUtil.getJob(params, "industry", String.class))
															.setSalaryFrom(MapUtil.getJob(params, "salaryFrom", String.class))
															.setSalaryTo(MapUtil.getJob(params, "salaryTo", String.class))
															.build();
		return builder;
	
	}
}
