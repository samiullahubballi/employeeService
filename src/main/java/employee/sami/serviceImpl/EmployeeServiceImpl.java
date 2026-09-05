package employee.sami.serviceImpl;

import employee.sami.entities.Employee;
import employee.sami.repository.EmployeeRepo;
import employee.sami.service.EmployeeService;

import java.util.List;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
@RequiredArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final PasswordEncoder passwordEncoder;

    //creating
    public Employee createEmp(Employee employee){

        String rawpassword = employee.getPassword();
        String hashedPassword = passwordEncoder.encode(rawpassword);

        employee.setPassword(hashedPassword);

        return employeeRepo.save(employee);
    }

    //read all
    public List<Employee> getallEmployees(){
        return employeeRepo.findAll();
    }

    //read employee by id
    public Employee getEmployee(String email){
        return employeeRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("Invalid email !!"));
    }

    //update employee
    public Employee updatEmployee(long id, Employee employee){

        Employee emp = employeeRepo.findById(id).orElseThrow();

        if (employee.getName() != null){
            emp.setName(employee.getName());
        }
        if (employee.getDept() != null){
            emp.setDept(employee.getDept());
        }
        if(employee.getEmail()!= null){
            emp.setEmail(employee.getEmail());
        }
        if(employee.getSalary() != null){
            emp.setSalary(employee.getSalary());
        }
        if(employee.getMobile() != null){
            emp.setMobile(employee.getMobile());
        }
        if(employee.getRole() != null){
            emp.setRole(employee.getRole());
        }
        // if(emp.getPassword() != null){
        //     emp.setPassword(employee.getPassword());
        // }

        return employeeRepo.save(emp);
    }

    //delete employeee
    public String DeleteEmplyee(long id){
        Employee employee = employeeRepo.findById(id).orElseThrow(()->
                new RuntimeException("Id does'nt exists !"));
        employeeRepo.delete(employee);
        return "Employee with ID : "+ id +" have been deleted !";
    }
}
