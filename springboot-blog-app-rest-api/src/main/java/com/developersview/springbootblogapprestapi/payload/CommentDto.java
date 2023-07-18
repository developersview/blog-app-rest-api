package com.developersview.springbootblogapprestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author pranoy.chakraborty
 * @Date 28/06/2023
 */
@Data
@Schema(
        description = "CommentDto Model Information"
)
public class CommentDto {
    private long id;

    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    @NotEmpty
    @Size(min = 5, message = "Comment body must be minimum 5 characters")
    private String body;
}
