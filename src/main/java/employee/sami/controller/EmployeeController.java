package employee.sami.controller;

import employee.sami.entities.Employee;
import employee.sami.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public Employee create(@Valid @RequestBody Employee employee){
        return employeeService.createEmp(employee);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getallEmployees(){
        return employeeService.getallEmployees();
    }

//    @GetMapping("/getEmployee/me")
//    public Employee getEmployee(Authentication authentication){
//        String email = authentication.getName();
//        return employeeService.getEmployee(email);
//    }

    @PatchMapping("/UpdateEmployee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable long id){
        return employeeService.updatEmployee(id,employee);
    }

    @DeleteMapping("/DeleteEmployee/{id}")
    public String DeleteEmployee( @PathVariable long id){
        return employeeService.DeleteEmplyee(id);
    }


}