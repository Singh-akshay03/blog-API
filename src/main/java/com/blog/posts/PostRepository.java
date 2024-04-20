package com.blog.posts;

import com.blog.category.Category;
import com.blog.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByUser(User user);

    List<Post> findAllByCategory(Category category);

}
