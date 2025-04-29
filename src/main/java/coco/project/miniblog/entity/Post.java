package coco.project.miniblog.entity;

import coco.project.miniblog.dto.PostDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="post")
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;

    @Column(name = "postTitle")
    private String postTitle;
    @Column(name = "postContent")
    private String postContent;

    @OneToMany(mappedBy="post", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Reply> replies;

    public static Post toEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setPostId(postDTO.getPostId());
        post.setPostTitle(postDTO.getPostTitle());
        post.setPostContent(postDTO.getPostContent());
        return post;
    }

    public Post(String title, String content) {
        this.postTitle = title;
        this.postContent = content;
    }
}
