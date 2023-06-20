package com.developersview.springbootblogapprestapi.service;

import com.developersview.springbootblogapprestapi.payload.PostDto;

/**
 * @author pranoy.chakraborty
 * @Date 20/06/2023
 */
public interface PostService {
    PostDto createPost(PostDto postDto);
}
