package com.iuuui.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

/**
 * @author iuuui
 * @date 2025/03/29 1454
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));

        String pwd = "123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(pwd);
        System.out.println("加密后：" + encode);

        System.out.println(bCryptPasswordEncoder.matches(pwd, encode));
    }
}
