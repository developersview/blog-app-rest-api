package com.developersview.springbootblogapprestapi.controller;

import com.developersview.springbootblogapprestapi.payload.CommentDto;
import com.developersview.springbootblogapprestapi.service.CommentService;
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
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> addComment(@PathVariable(value = "postId") long postId,
                                                 @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(
                commentService.createComment(postId, commentDto),
                HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getAllCommentsByPostId(@PathVariable(value = "postId") long postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") long postId,
                                                     @PathVariable(value = "commentId") long commentId) {
        return new ResponseEntity<>(
                commentService.getCommentById(postId, commentId),
                HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateCommentById(@PathVariable(value = "postId") long postId,
                                                        @PathVariable(value = "commentId") long commentId,
                                                        @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(
                commentService.updateComment(postId, commentId, commentDto),
                HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable(value = "postId") long postId,
                                                    @PathVariable(value = "commentId") long commentId){
        commentService.deleteComment(postId,commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
