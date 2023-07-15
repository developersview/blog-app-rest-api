package com.developersview.springbootblogapprestapi.repository;

import com.developersview.springbootblogapprestapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author pranoy.chakraborty
 * @Date 19/06/2023
 */

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByCategoryId(Long categoryId);
}
