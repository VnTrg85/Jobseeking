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

import jobseekingbe.api.entity.Employee;
import jobseekingbe.api.service.Employee.EmployeeService;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/employee")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }
    @GetMapping("/getByUserId/{id}")
    public ResponseEntity<Employee> getEmployeeByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeByUserId(id));
    }

    @PutMapping("/update")
    public ResponseEntity<String> putMethodName(@RequestBody Employee entity) { 
        return ResponseEntity.ok(employeeService.updateEmployee(entity));
    }
    
    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }
}
