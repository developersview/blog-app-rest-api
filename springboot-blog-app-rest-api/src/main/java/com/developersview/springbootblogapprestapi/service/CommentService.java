package com.developersview.springbootblogapprestapi.service;

import com.developersview.springbootblogapprestapi.payload.CommentDto;

import java.util.List;

/**
 * @author pranoy.chakraborty
 * @Date 28/06/2023
 */
public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getAllCommentsByPostId(long postId);

    CommentDto getCommentById(long postId, long commentId);

    CommentDto updateComment(long postId, long commentId, CommentDto commentDto);

    void deleteComment(long postId, long commentId);
}
