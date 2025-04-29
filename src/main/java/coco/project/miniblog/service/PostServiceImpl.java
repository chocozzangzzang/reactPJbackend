package coco.project.miniblog.service;

import coco.project.miniblog.dto.PostDTO;
import coco.project.miniblog.dto.ReplyDTO;
import coco.project.miniblog.entity.Post;
import coco.project.miniblog.entity.Reply;
import coco.project.miniblog.repository.PostRepository;
import coco.project.miniblog.repository.ReplyRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;

    public PostServiceImpl(PostRepository postRepository, ReplyRepository replyRepository) {
        this.postRepository = postRepository;
        this.replyRepository = replyRepository;
    }

    @Override
    public Post writePost(PostDTO postDTO) {
        Post post = new Post(postDTO.getPostTitle(), postDTO.getPostContent());
        return postRepository.save(post);
    }

    @Override
    public List<PostDTO> getPosts() {
        List<Post> allPosts = postRepository.findAll();
        return allPosts.stream()
                .map(post -> new PostDTO(post.getPostId(), post.getPostTitle()))
                .toList();
    };

    @Override
    public PostDTO getPost(Long pid) {
        Post targetPost = postRepository.findByPid(pid);
        List<Reply> targetReplies = replyRepository.getReplies(pid);

        List<ReplyDTO> replyDTOs = targetReplies.stream()
                        .map(reply -> new ReplyDTO(reply.getReplyId(), reply.getReplyContent()))
                                .toList();
        return new PostDTO(targetPost.getPostId(), targetPost.getPostTitle(), targetPost.getPostContent(), replyDTOs);
    };

    @Override
    public void deletePost(Long pid) {
        postRepository.deleteById(pid);
    }

    @Override
    public Post editPost(PostDTO postDTO) {
        Post post = Post.toEntity(postDTO);
        return postRepository.save(post);
    }
}
