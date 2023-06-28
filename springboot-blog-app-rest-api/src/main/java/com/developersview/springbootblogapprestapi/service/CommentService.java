package com.developersview.springbootblogapprestapi.service;

import com.developersview.springbootblogapprestapi.payload.CommentDto;

/**
 * @author pranoy.chakraborty
 * @Date 28/06/2023
 */
public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
}
