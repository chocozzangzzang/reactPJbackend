package coco.project.miniblog.controller;

import coco.project.miniblog.dto.LoginDTO;
import coco.project.miniblog.dto.UserDTO;
import coco.project.miniblog.dto.UserManageDTO;
import coco.project.miniblog.service.AuthServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/auth/*")
@AllArgsConstructor
@CrossOrigin(origins="http://localhost:3000")
public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping("login")
    public LoginDTO login(@RequestBody UserDTO userDTO) {
        LoginDTO loginDTO = authService.login(userDTO);
        log.info("login : {}", loginDTO.toString());
        return loginDTO;
    }

    @PostMapping("signup")
    public String signup(@RequestBody UserDTO userDTO) {
        return authService.signup(userDTO);
    }

    @GetMapping("userlist")
    public List<UserManageDTO> userList() {return authService.userlist();}

}
