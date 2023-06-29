package com.developersview.springbootblogapprestapi.payload;

import com.developersview.springbootblogapprestapi.entity.Comment;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotEmpty
    @Size(min = 5, message = "Post Title should have at least 5 characters")
    private String title;

    @NotEmpty
    @Size(min = 10, message = "Post Description should have at least 10 characters")
    private String description;

    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
}
