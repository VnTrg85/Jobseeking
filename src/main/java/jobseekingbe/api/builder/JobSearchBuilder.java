package jobseekingbe.api.builder;

import org.springframework.stereotype.Component;

@Component
public class JobSearchBuilder {
    private String title;
    private String location;
    private String industry;
    private String salaryFrom;
    private String salaryTo;

    public JobSearchBuilder() {}

    public JobSearchBuilder(Builder builder) {
        this.title = builder.title;
        this.location = builder.location;
        this.industry = builder.industry;
        this.salaryFrom = builder.salaryFrom;
        this.salaryTo = builder.salaryTo;
    }

    // Getter
    public String getTitle() {
        return title;
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

    public static class Builder {
        private String title;
        private String location;
        private String industry;
        private String salaryFrom;
        private String salaryTo;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setIndustry(String industry) {
            this.industry = industry;
            return this;
        }

        public Builder setSalaryFrom(String salaryFrom) {
            this.salaryFrom = salaryFrom;
            return this;
        }

        public Builder setSalaryTo(String salaryTo) {
            this.salaryTo = salaryTo;
            return this;
        }

        public JobSearchBuilder build() {
            return new JobSearchBuilder(this);
        }
    }
}
