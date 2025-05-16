package coco.project.miniblog.repository;

import coco.project.miniblog.dto.UserManageDTO;
import coco.project.miniblog.entity.User;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    @Query(value = "SELECT * FROM USERS AS U WHERE U.role = 'USER'", nativeQuery = true)
    List<User> getUserList();
}
