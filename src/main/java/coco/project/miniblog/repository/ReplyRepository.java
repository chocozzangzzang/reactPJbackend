package coco.project.miniblog.repository;

import coco.project.miniblog.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query(value = "SELECT * FROM REPLY R WHERE R.post_id=:postid", nativeQuery = true)
    public List<Reply> getReplies(@Param(value="postid") Long pid);
}
