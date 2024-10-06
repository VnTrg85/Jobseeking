package jobseekingbe.api.service.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jobseekingbe.api.entity.Employee;
import jobseekingbe.api.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public String addEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            return "Added";
        } catch (Exception e) {
            return "Failed to add employee";
        }
    }

    @Override
    public String updateEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            return "Updated";
        } catch (Exception e) {
            return "Failed to update employee";
        }
    }

    @Override
    public String deleteEmployee(Long id) {
        try {
            employeeRepository.deleteById(id);;
            return "Deleted";
        } catch (Exception e) {
            return "Failed to delete employee";
        }
    }

    @Override
    public Employee getEmployeeByUserId(Long id) {
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {

            if( employee.getUserEmployee() != null && employee.getUserEmployee().getId() == id) {
                return employee;
            }
        }
        return null;
    }

}
