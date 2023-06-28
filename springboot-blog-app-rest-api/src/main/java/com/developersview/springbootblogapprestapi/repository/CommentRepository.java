package com.developersview.springbootblogapprestapi.repository;

import com.developersview.springbootblogapprestapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author pranoy.chakraborty
 * @Date 28/06/2023
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}
