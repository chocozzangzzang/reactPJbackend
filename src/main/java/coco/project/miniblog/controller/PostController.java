package coco.project.miniblog.controller;

import coco.project.miniblog.dto.PostDTO;
import coco.project.miniblog.entity.Post;
import coco.project.miniblog.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post/*")
@AllArgsConstructor
@CrossOrigin(origins="http://localhost:3000")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("write")
    public Post postWrite(@RequestBody PostDTO postDTO) {
        return postService.writePost(postDTO);
    }

    @GetMapping("list")
    public ResponseEntity<List<PostDTO>> allPosts() {
        List<PostDTO> postDTOList = postService.getPosts();
        return ResponseEntity.ok(postDTOList);
    }

    @GetMapping("detail/{pid}")
    public ResponseEntity<PostDTO> postDetail(@PathVariable Long pid) {
        PostDTO postDTO = postService.getPost(pid);
        return ResponseEntity.ok(postDTO);
    }

    @PutMapping("edit/{pid}")
    public Post postEdit(@RequestBody PostDTO postDTO) {
        return postService.editPost(postDTO);
    }

    @DeleteMapping("delete/{pid}")
    public void postDelete(@PathVariable Long pid) {
        postService.deletePost(pid);
    }
}
