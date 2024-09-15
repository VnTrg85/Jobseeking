package jobseekingbe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobseekingbe.api.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{

}
