package com.developersview.springbootblogapprestapi.controller;

import com.developersview.springbootblogapprestapi.payload.JwtAuthResponse;
import com.developersview.springbootblogapprestapi.payload.LoginDto;
import com.developersview.springbootblogapprestapi.payload.RegisterDto;
import com.developersview.springbootblogapprestapi.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pranoy.chakraborty
 * @Date 09/07/2023
 */
@RestController
@RequestMapping("/api/auth")
@Tag(
        name = "Login and Register REST API"
)
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //login
    @Operation(
            summary = "User Login / Signin Rest Endpoint",
            description = "This endpoint is used to login for an existing user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @PostMapping(value = {"/login","signin"})
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return ResponseEntity.ok(jwtAuthResponse);
    }

    //register
    @Operation(
            summary = "User register / Signup Rest Endpoint",
            description = "This endpoint is used to register a new user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status - 200 SUCCESS"
    )
    @PostMapping(value = {"/register","/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
