package jobseekingbe.api.service.Employee;

import java.util.List;


import jobseekingbe.api.entity.Employee;

public interface EmployeeService {
    public List<Employee> getEmployees();
    public Employee getEmployee(Long id);
    public Employee getEmployeeByUserId(Long id);
    public String addEmployee(Employee employee);
    public String updateEmployee(Employee employee);
    public String deleteEmployee(Long id);
}
