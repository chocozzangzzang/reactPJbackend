package coco.project.miniblog.dto;

import coco.project.miniblog.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class PostDTO {

    private Long postId;
    private String postTitle;
    private String postContent;

    private List<ReplyDTO> replyDTOS;

    public PostDTO(Long id, String title, String content, List<ReplyDTO> replyDTOs) {
        this.postId = id;
        this.postTitle = title;
        this.postContent = content;
        this.replyDTOS = replyDTOs;
    }

    public PostDTO(Long id, String title) {
        this.postId = id;
        this.postTitle = title;
    }

    public PostDTO(String title, String content) {
        this.postTitle = title;
        this.postContent = content;
    }

    public PostDTO(Long id, String title, String content) {
        this.postId = id;
        this.postTitle = title;
        this.postContent = content;
    }
}
