package jobseekingbe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobseekingbe.api.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
