package jobseekingbe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobseekingbe.api.entity.UserJobApplied;

@Repository
public interface UserJobAppliedRepository extends JpaRepository<UserJobApplied,Long>{
    
}
