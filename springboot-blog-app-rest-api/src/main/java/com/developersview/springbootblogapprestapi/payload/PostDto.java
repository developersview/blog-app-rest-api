package com.developersview.springbootblogapprestapi.payload;

import com.developersview.springbootblogapprestapi.entity.Comment;
import lombok.*;

import java.util.Set;

/**
 * @author pranoy.chakraborty
 * @Date 20/06/2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;
    private Set<CommentDto> comments;
}
