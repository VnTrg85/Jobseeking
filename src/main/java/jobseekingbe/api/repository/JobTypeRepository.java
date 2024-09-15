package jobseekingbe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobseekingbe.api.entity.JobType;

@Repository
public interface JobTypeRepository extends JpaRepository<JobType,Long> {

}
