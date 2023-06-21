package com.developersview.springbootblogapprestapi.service;

import com.developersview.springbootblogapprestapi.payload.PostDto;

import java.util.List;

/**
 * @author pranoy.chakraborty
 * @Date 20/06/2023
 */
public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
