package employee.sami.service;

import employee.sami.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public Employee createEmp(Employee employee);
    public List<Employee> getallEmployees();
    public Employee getEmployee(String email);
    public Employee updatEmployee(long id, Employee employee);
    public String DeleteEmplyee(long id);
}
