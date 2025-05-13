package coco.project.miniblog.service;

import coco.project.miniblog.dto.LoginDTO;
import coco.project.miniblog.dto.UserDTO;

public interface AuthService {
    public LoginDTO login(UserDTO userDTO);
    public String signup(UserDTO userDTO);
}
