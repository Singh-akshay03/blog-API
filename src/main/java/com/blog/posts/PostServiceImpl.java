package com.blog.posts;

import com.blog.DTOs.PostDTO;
import com.blog.Exceptions.CategoryNotFoundException;
import com.blog.Exceptions.PostNotFoundException;
import com.blog.Exceptions.UserNotFoundException;
import com.blog.category.Category;
import com.blog.category.CategoryRepository;
import com.blog.user.User;
import com.blog.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Post createPost(PostDTO postDTO, Long userId, Long categoryId) {
        Post post=this.modelMapper.map(postDTO,Post.class);
        post.setCategory(categoryRepository.findById(categoryId)
                .orElseThrow(()->new CategoryNotFoundException(categoryId)));
        post.setUser(userRepository.findById(userId)
                .orElseThrow(()->new UserNotFoundException(userId)));
        post.setCreatedAt(new Date());
        post.setImage("default.png");
        return this.postRepository.save(post);
    }

    @Override
    public Post updatePost(PostDTO postDTO, Long postId) {
        Post post=this.postRepository.findById(postId)
                .orElseThrow(()->new PostNotFoundException(postId));
        if(postDTO.getTitle()!=null){
            post.setTitle(postDTO.getTitle());
        }
        if(postDTO.getContent()!=null){
            post.setContent(postDTO.getContent());
        }
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        Post post=this.postRepository.findById(postId)
                .orElseThrow(()->new PostNotFoundException(postId));
        postRepository.delete(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getPostsByUser(Long userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new UserNotFoundException(userId));
        return postRepository.findAllByUser(user);
    }

    @Override
    public List<Post> getPostsByCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new CategoryNotFoundException(categoryId));
        return postRepository.findAllByCategory(category);
    }
}
