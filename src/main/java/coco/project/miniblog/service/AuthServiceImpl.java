package coco.project.miniblog.service;

import coco.project.miniblog.dto.LoginDTO;
import coco.project.miniblog.dto.UserDTO;
import coco.project.miniblog.dto.UserManageDTO;
import coco.project.miniblog.entity.User;
import coco.project.miniblog.repository.UserRepository;
import coco.project.miniblog.security.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService{

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(JwtUtil jwtUtil, AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginDTO login(UserDTO userDTO) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userDTO.getUsername(),
                            userDTO.getPassword()
                    )
            );
            String jwttoken = jwtUtil.generateToken(userDTO.getUsername());
            String userRole = authentication.getAuthorities().toString();
            log.info("service : {} == {}", jwttoken, userRole);
            return new LoginDTO(userDTO.getUsername(), jwttoken, userRole);
        } catch (AuthenticationException e) {
            throw new RuntimeException("로그인 실패 ", e);
        }
    }

    @Override
    public String signup(UserDTO userDTO) {
        Optional<User> user = userRepository.findByUsername(userDTO.getUsername());
        if(user.isPresent()) return "이미 가입된 회원입니다.";
        userRepository.save(
                new User(userDTO.getUsername(),
                        passwordEncoder.encode(userDTO.getPassword()),
                        "USER")
        );
        return "가입되었습니다.";
    }

    public List<UserManageDTO> userlist() {
        List<User> users = userRepository.getUserList();
        System.out.println(users);
        List<UserManageDTO> userDTOs = new ArrayList<>();
        for(User u : users) {
            System.out.println(u);
            UserManageDTO umdto = new UserManageDTO(u.getUserId(), u.getUsername(), u.getRole());
            userDTOs.add(umdto);
        }
        System.out.println(userDTOs);
        return userDTOs;
    }
}
