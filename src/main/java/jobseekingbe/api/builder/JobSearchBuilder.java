package jobseekingbe.api.builder;

import org.springframework.stereotype.Component;

@Component
public class JobSearchBuilder {
	private String name;
	private String location;
	private String industry;
	private String salaryFrom;
	private String salaryTo;	
	
	private JobSearchBuilder(Buider builder) {
		this.name = builder.name;
		this.location = builder.location;
		this.industry = builder.industry;
		this.salaryFrom = builder.salaryFrom;
		this.salaryTo = builder.salaryTo;

	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public String getIndustry() {
		return industry;
	}

	public String getSalaryFrom() {
		return salaryFrom;
	}
	public String getSalaryTo() {
		return salaryTo;
	}





	public static class Buider{
		private String name;
		private String location;
		private String industry;
		private String salaryFrom;
		private String salaryTo;	
		
		public Buider setName(String name) {
			this.name=name;
			return this;
		}
		public Buider setLocation(String location) {
			this.location = location;
			return this;

		}
		public Buider setIndustry(String industry) {
			this.industry = industry;
			return this;

		}

		public Buider setSalaryFrom(String salaryFrom) {
			this.salaryFrom = salaryFrom;
			return this;

		}
		public Buider setSalaryTo(String salaryTo) {
			this.salaryTo = salaryTo;
			return this;

		}
		public JobSearchBuilder build() {
			return new JobSearchBuilder(this);
		}
		
	}
}
