package com.color.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author yd
 * @version 1.0
 * @date 2021/4/16 16:04
 */
public class PasswordUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }
}
