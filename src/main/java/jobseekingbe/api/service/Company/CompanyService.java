package jobseekingbe.api.service.Company;

import java.util.List;
import java.util.Optional;

import jobseekingbe.api.entity.Company;

public interface CompanyService {
    public List<Company> getCompanies();
    
    public Company getCompany(Long id);
    public Company getCompanyByUserID(Long id);
    public String addCompany(Company company);
    public String updateCompany(Company company);
    public String deleteCompany(Long id);
}
