package employee.sami.serviceImpl;

import employee.sami.DTO.LoginDTO;
import employee.sami.DTO.LoginResponseDTO;
import employee.sami.entities.Employee;
import employee.sami.repository.EmployeeRepo;
import employee.sami.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final EmployeeRepo employeeRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(EmployeeRepo employeeRepo,PasswordEncoder passwordEncoder,JwtService jwtService){
        this.employeeRepo=employeeRepo;
        this.passwordEncoder=passwordEncoder;
        this.jwtService=jwtService;
    }

    public LoginResponseDTO login(LoginDTO request){
        Employee employee = employeeRepo.findByEmail(request.email())
                .orElseThrow(
                        ()-> new RuntimeException("Invalid Email !")
                );
        boolean passwordMatches =
                passwordEncoder.matches(
                        request.password(),
                        employee.getPassword()
                );
        if(!passwordMatches){
            throw new RuntimeException("Invalid Password !!");
        }
        String token = jwtService.generateToken(employee);
        return new LoginResponseDTO(token, employee.getRole().name());
    }
}
