package jobseekingbe.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jobseekingbe.api.entity.Company;
import jobseekingbe.api.service.Company.CompanyService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Company>> getCompanies() {
        return ResponseEntity.ok(companyService.getCompanies());
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getCompany(id));
    }


    @GetMapping("/getByUserID/{id}")
    public ResponseEntity<Company> getCompanyByUserID(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getCompanyByUserID(id));
    }
    
    

    @PostMapping("/add")
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.addCompany(company));
    }
}
