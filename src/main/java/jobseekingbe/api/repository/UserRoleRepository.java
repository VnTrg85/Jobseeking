package jobseekingbe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobseekingbe.api.entity.UserRole;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    
}
