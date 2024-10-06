package jobseekingbe.api.service.Company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jobseekingbe.api.entity.Company;
import jobseekingbe.api.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public String addCompany(Company company) {
        try {
            companyRepository.save(company);
            return "Added";
        } catch (Exception e) {
            return "Failed to add company";
        }
    }

    @Override
    public String updateCompany(Company company) {
        try {
            companyRepository.save(company);
            return "Updated";
        } catch (Exception e) {
            return "Failed to update company";
        }
    }

    @Override
    public String deleteCompany(Long id) {
        try {
            companyRepository.deleteById(id);;
            return "Deleted";
        } catch (Exception e) {
            return "Failed to delete company";
        }
    }

    @Override
    public Company getCompanyByUserID(Long id) {
        List<Company> companies = companyRepository.findAll();
        for (Company company : companies) {
            if(company.getUserCompany().getId() == id ) {
                return company;
            }
        }
        return null;
    }

}
