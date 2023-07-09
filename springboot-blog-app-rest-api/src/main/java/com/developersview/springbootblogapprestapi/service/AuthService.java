package com.developersview.springbootblogapprestapi.service;

import com.developersview.springbootblogapprestapi.payload.LoginDto;

/**
 * @author pranoy.chakraborty
 * @Date 09/07/2023
 */
public interface AuthService {
    String login(LoginDto loginDto);
}
