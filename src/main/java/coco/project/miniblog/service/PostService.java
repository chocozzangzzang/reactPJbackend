package coco.project.miniblog.service;


import coco.project.miniblog.dto.PostDTO;
import coco.project.miniblog.entity.Post;

import java.util.List;

public interface PostService {

    public Post writePost(PostDTO postDTO);

    public List<PostDTO> getPosts();

    public PostDTO getPost(Long pid);

    public void deletePost(Long pid);

    public Post editPost(PostDTO postDTO);
}
