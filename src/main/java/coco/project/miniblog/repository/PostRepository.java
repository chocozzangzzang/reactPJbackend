package coco.project.miniblog.repository;

import coco.project.miniblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value="SELECT * FROM post p WHERE p.post_id=:postid", nativeQuery = true)
    public Post findByPid(@Param(value="postid") Long pid);
}
