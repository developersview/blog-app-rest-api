package com.developersview.springbootblogapprestapi.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author pranoy.chakraborty
 * @Date 09/07/2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "RegisterDto Model Information"
)
public class RegisterDto {
    private String name;
    private String username;
    private String email;
    private String password;
}
