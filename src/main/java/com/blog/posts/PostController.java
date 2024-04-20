package com.blog.posts;

import com.blog.DTOs.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/posts")
public class PostController {
    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("/{userId}/{categoryId}")
    public ResponseEntity<Post> createPost(@RequestBody PostDTO postDTO, @PathVariable Long userId, @PathVariable Long categoryId) {
        return new ResponseEntity<>(this.postService.createPost(postDTO, userId, categoryId)
                ,HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@RequestBody PostDTO postDTO, @PathVariable Long postId) {
        return new ResponseEntity<>(this.postService.updatePost(postDTO, postId)
                ,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        this.postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Post>> getAllPosts(){
        return new ResponseEntity<>(this.postService.getAllPosts()
                ,HttpStatus.OK);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable Long userId){
        return new ResponseEntity<>(this.postService.getPostsByUser(userId)
                ,HttpStatus.OK);
    }

    @GetMapping("/categoryId/{categoryId}")
    public ResponseEntity<List<Post>> getPostsByCategory(@PathVariable Long categoryId){
        return new ResponseEntity<>(this.postService.getPostsByCategory(categoryId)
                ,HttpStatus.OK);
    }
}

