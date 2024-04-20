package com.blog.posts;

import com.blog.DTOs.PostDTO;

import java.util.List;

public interface IPostService {
    //CREATE A POST
    Post createPost(PostDTO postDTO,Long userId,Long categoryId);

    //UPDATE POST
    Post updatePost(PostDTO postDTO,Long postId);
    // DELETE POST
    void deletePost(Long postId);

    //GET ALL POST
    List<Post> getAllPosts();

    //GET POST BY USER ID
    List<Post> getPostsByUser(Long userId);

    // GET POST BY CATEGORY ID
    List<Post> getPostsByCategory(Long categoryId);

}
