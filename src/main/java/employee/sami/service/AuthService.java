package employee.sami.service;

import employee.sami.DTO.LoginDTO;
import employee.sami.DTO.LoginResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    public LoginResponseDTO login(LoginDTO request);
}
