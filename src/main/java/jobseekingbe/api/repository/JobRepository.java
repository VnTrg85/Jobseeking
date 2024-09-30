package jobseekingbe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobseekingbe.api.entity.Job;
import jobseekingbe.api.repository.custom.JobRepositoryCustom;
@Repository
public interface JobRepository extends JpaRepository<Job,Long>,JobRepositoryCustom{
	

	

}
