package employee.sami.repository;

import employee.sami.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  EmployeeRepo extends JpaRepository<Employee,Long> {
    public Optional<Employee> findByEmail(String email);

}
