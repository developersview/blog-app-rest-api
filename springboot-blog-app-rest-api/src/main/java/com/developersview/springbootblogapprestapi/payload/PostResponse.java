package com.developersview.springbootblogapprestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author pranoy.chakraborty
 * @Date 22/06/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "PostResponse Model Information"
)
public class PostResponse {
    private List<PostDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElement;
    private int totalPages;
    private boolean last;
}
