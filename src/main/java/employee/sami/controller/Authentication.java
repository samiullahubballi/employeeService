package employee.sami.controller;

import employee.sami.DTO.LoginDTO;
import employee.sami.DTO.LoginResponseDTO;
import employee.sami.service.AuthService;
import employee.sami.serviceImpl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Authentication {

    @Autowired
    AuthService authService;


    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginDTO request){
        return authService.login(request);
    }
}
