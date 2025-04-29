package coco.project.miniblog.dto;

import coco.project.miniblog.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReplyDTO {

    private Long replyId;
    private Long postId;

    private String replyContent;

    private Post post;

    public ReplyDTO(Long id, String reply) {
        this.replyId = id;
        this.replyContent = reply;
    }

    public ReplyDTO(String reply, Long pid) {
        this.replyContent = reply;
        this.postId = pid;
    }

    public ReplyDTO(Long replyId, String reply, Long pid) {
        this.replyId = replyId;
        this.replyContent = reply;
        this.postId = pid;
    }
}
