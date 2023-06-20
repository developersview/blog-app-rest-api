package com.developersview.springbootblogapprestapi.service.impl;

import com.developersview.springbootblogapprestapi.entity.Post;
import com.developersview.springbootblogapprestapi.payload.PostDto;
import com.developersview.springbootblogapprestapi.repository.PostRepository;
import com.developersview.springbootblogapprestapi.service.PostService;
import org.springframework.stereotype.Service;

/**
 * @author pranoy.chakraborty
 * @Date 20/06/2023
 */
@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        //convert dto to entity
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);

        //convert entity to dto
        PostDto postResponse = mapToDto(newPost);
        return postResponse;
    }

    private PostDto mapToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
