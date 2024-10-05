package jobseekingbe.api.service.Company;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jobseekingbe.api.entity.Company;
import jobseekingbe.api.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    
    @Override
    public void setCompany(Company company) {
        companyRepository.save(company);
    }
}
