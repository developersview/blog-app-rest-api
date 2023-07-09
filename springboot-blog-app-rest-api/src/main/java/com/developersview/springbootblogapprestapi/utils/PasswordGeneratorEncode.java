package com.developersview.springbootblogapprestapi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author pranoy.chakraborty
 * @Date 09/07/2023
 */
public class PasswordGeneratorEncode {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("pra12345"));
        System.out.println(passwordEncoder.encode("jon12345"));
        System.out.println(passwordEncoder.encode("martha123"));
    }
}
