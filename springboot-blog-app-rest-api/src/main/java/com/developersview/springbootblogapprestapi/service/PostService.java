package com.developersview.springbootblogapprestapi.service;

import com.developersview.springbootblogapprestapi.payload.PostDto;
import com.developersview.springbootblogapprestapi.payload.PostResponse;

import java.util.List;

/**
 * @author pranoy.chakraborty
 * @Date 20/06/2023
 */
public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

    List<PostDto> getPostsByCategory(Long categoryId);
}
