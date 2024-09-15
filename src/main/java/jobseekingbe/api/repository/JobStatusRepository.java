package jobseekingbe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobseekingbe.api.entity.JobStatus;

@Repository
public interface JobStatusRepository extends  JpaRepository<JobStatus,Long>{

}
