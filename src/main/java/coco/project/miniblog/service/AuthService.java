package coco.project.miniblog.service;

import coco.project.miniblog.dto.UserDTO;

public interface AuthService {
    public String login(UserDTO userDTO);
    public String signup(UserDTO userDTO);
}
