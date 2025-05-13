package coco.project.miniblog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LoginDTO {
    private String username;
    private String token;
    private String role;
}
