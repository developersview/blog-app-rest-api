package com.developersview.springbootblogapprestapi.payload;

import lombok.Data;

/**
 * @author pranoy.chakraborty
 * @Date 20/06/2023
 */
@Data
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;
}
