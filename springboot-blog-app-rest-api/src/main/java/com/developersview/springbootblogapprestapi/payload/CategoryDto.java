package com.developersview.springbootblogapprestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author pranoy.chakraborty
 * @Date 15/07/2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Category Model Information"
)
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
}
