package com.developersview.springbootblogapprestapi.service.impl;

import com.developersview.springbootblogapprestapi.entity.Comment;
import com.developersview.springbootblogapprestapi.entity.Post;
import com.developersview.springbootblogapprestapi.exception.BlogApiException;
import com.developersview.springbootblogapprestapi.exception.ResourceNotFoundException;
import com.developersview.springbootblogapprestapi.payload.CommentDto;
import com.developersview.springbootblogapprestapi.repository.CommentRepository;
import com.developersview.springbootblogapprestapi.repository.PostRepository;
import com.developersview.springbootblogapprestapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pranoy.chakraborty
 * @Date 28/06/2023
 */
@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);

        //retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        //set post to comment entity
        comment.setPost(post);

        //save comment
        Comment newComment = commentRepository.save(comment);
        return mapToDto(newComment);
    }

    @Override
    public List<CommentDto> getAllCommentsByPostId(long postId) {
        List<Comment> allComments = commentRepository.findByPostId(postId);
        return allComments.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(long postId, long commentId) {
        Comment comment = retrieveComment(postId, commentId);
        return mapToDto(comment);
    }

    @Override
    public CommentDto updateComment(long postId, long commentId, CommentDto commentDto) {
        Comment comment = retrieveComment(postId, commentId);
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        Comment updatedComment = commentRepository.save(comment);
        return mapToDto(updatedComment);
    }

    @Override
    public void deleteComment(long postId, long commentId) {
        Comment comment = retrieveComment(postId, commentId);
        commentRepository.delete(comment);
    }

    private CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }

    private Comment retrieveComment(long postId, long commentId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", commentId));
        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Comment doesn't belong to post");
        }
        return comment;
    }
}
