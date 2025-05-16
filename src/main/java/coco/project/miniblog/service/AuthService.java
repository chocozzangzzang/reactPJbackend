package coco.project.miniblog.service;

import coco.project.miniblog.dto.LoginDTO;
import coco.project.miniblog.dto.UserDTO;
import coco.project.miniblog.dto.UserManageDTO;

import java.util.List;

public interface AuthService {
    public LoginDTO login(UserDTO userDTO);
    public String signup(UserDTO userDTO);
    public List<UserManageDTO> userlist();
}
