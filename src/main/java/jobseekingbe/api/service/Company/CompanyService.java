package jobseekingbe.api.service.Company;

import java.util.List;

import jobseekingbe.api.entity.Company;

public interface CompanyService {
    public List<Company> getAllCompanies();
    public void setCompany(Company Company);

}
