package com.developersview.springbootblogapprestapi.controller;

import com.developersview.springbootblogapprestapi.payload.PostDto;
import com.developersview.springbootblogapprestapi.payload.PostResponse;
import com.developersview.springbootblogapprestapi.service.PostService;
import com.developersview.springbootblogapprestapi.utils.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pranoy.chakraborty
 * @Date 20/06/2023
 */
@RestController
@RequestMapping("/api/v1/posts")
@Tag(
        name = "CRUD REST API for Post Resource"
)
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //create a post
    @Operation(
            summary = "Create Post Rest Endpoint",
            description = "This endpoint is used to save post into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status - 201 CREATED"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    //get all posts
    @Operation(
            summary = "Get All Posts Rest Endpoint",
            description = "This endpoint is used to fetch all the post details from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    //get a post by id
    @Operation(
            summary = "Get Post by ID Rest Endpoint",
            description = "This endpoint is used to get only one post details from the database based on post ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    //update post
    @Operation(
            summary = "Update Post by ID Rest Endpoint",
            description = "This endpoint is used to update a post details into database based on post ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable long id) {
        PostDto getPostResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(getPostResponse, HttpStatus.OK);
    }

    //delete post
    @Operation(
            summary = "Delete Post by ID Rest Endpoint",
            description = "This endpoint is used to delete a post details from the database based on category ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @SecurityRequirement(
            name = "Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post has been successfully deleted", HttpStatus.OK);
    }

    //get posts by category id
    @Operation(
            summary = "Get Post by Category Rest Endpoint",
            description = "This endpoint is used to get posts details from the database based on post ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @GetMapping("/category/{id}")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable("id") Long categoryId){
        List<PostDto> posts = postService.getPostsByCategory(categoryId);
        return ResponseEntity.ok(posts);
    }
}
