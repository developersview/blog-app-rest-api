package com.developersview.springbootblogapprestapi.controller;

import com.developersview.springbootblogapprestapi.payload.CommentDto;
import com.developersview.springbootblogapprestapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                                                 @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }
}
