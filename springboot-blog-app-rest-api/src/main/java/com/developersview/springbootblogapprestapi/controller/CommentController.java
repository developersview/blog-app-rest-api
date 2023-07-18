package com.developersview.springbootblogapprestapi.controller;

import com.developersview.springbootblogapprestapi.payload.CommentDto;
import com.developersview.springbootblogapprestapi.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pranoy.chakraborty
 * @Date 28/06/2023
 */
@RestController
@RequestMapping("/api/")
@Tag(
        name = "CRUD REST API for Comment Resource"
)
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    //create a comment
    @Operation(
            summary = "Create Comment Rest Endpoint",
            description = "This endpoint is used to save a comment for a post into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status - 201 CREATED"
    )
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> addComment(@PathVariable(value = "postId") long postId,
                                                 @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(
                commentService.createComment(postId, commentDto),
                HttpStatus.CREATED);
    }

    //get all comments
    @Operation(
            summary = "Get All Comments Rest Endpoint",
            description = "This endpoint is used to get all comments for a post from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getAllCommentsByPostId(@PathVariable(value = "postId") long postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    //get a comment by id
    @Operation(
            summary = "Get a Comment by comment ID Rest Endpoint",
            description = "This endpoint is used to get single comment for a post from database by comment ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") long postId,
                                                     @PathVariable(value = "commentId") long commentId) {
        return new ResponseEntity<>(
                commentService.getCommentById(postId, commentId),
                HttpStatus.OK);
    }

    //update a comment by id
    @Operation(
            summary = "Update Comment Rest Endpoint",
            description = "This endpoint is used to update a comment for a post into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateCommentById(@PathVariable(value = "postId") long postId,
                                                        @PathVariable(value = "commentId") long commentId,
                                                        @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(
                commentService.updateComment(postId, commentId, commentDto),
                HttpStatus.OK);
    }

    //delete a comment by id
    @Operation(
            summary = "Delete Comment Rest Endpoint",
            description = "This endpoint is used to delete a comment from a post from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable(value = "postId") long postId,
                                                    @PathVariable(value = "commentId") long commentId){
        commentService.deleteComment(postId,commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
