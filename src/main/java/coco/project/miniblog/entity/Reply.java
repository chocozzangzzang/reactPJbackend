package coco.project.miniblog.entity;

import coco.project.miniblog.dto.ReplyDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reply {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long replyId;

    @Column(name="replyContent")
    private String replyContent;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="post_id")
    private Post post;

    public Reply(String replyContent, Long postId) {
        this.replyContent = replyContent;
        // 새로 post를 선언해서 할당해주어야함 //
        Post tempPost = new Post();
        tempPost.setPostId(postId);
        this.post = tempPost;
    }

    public Reply(Long replyId, String replyContent, Long postId) {
        this.replyId = replyId;
        this.replyContent = replyContent;
        // 새로 post를 선언해서 할당해주어야함 //
        Post tempPost = new Post();
        tempPost.setPostId(postId);
        this.post = tempPost;
    }

    public static Reply toEntity(ReplyDTO replyDTO) {
        Reply reply = new Reply();
        reply.setReplyId(replyDTO.getReplyId());
        reply.setReplyContent(replyDTO.getReplyContent());
        Post post = new Post();
        post.setPostId(replyDTO.getPostId());
        reply.setPost(post);
        return reply;
    }
}
