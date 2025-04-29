package coco.project.miniblog.controller;

import coco.project.miniblog.dto.UserDTO;
import coco.project.miniblog.service.AuthServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth/*")
@AllArgsConstructor
@CrossOrigin(origins="http://localhost:3000")
public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping("login")
    public String login(@RequestBody UserDTO userDTO) {
        return authService.login(userDTO);
    }

    @PostMapping("signup")
    public String signup(@RequestBody UserDTO userDTO) {
        return authService.signup(userDTO);
    }

}
