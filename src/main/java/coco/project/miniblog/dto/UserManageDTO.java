package coco.project.miniblog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserManageDTO {
    public Long userId;
    public String username;
    public String role;
}
