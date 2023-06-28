package com.developersview.springbootblogapprestapi.payload;

import lombok.Data;

/**
 * @author pranoy.chakraborty
 * @Date 28/06/2023
 */
@Data
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}
