package jobseekingbe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobseekingbe.api.entity.Job;
@Repository
public interface JobRepository extends JpaRepository<Job,Long> {

}
