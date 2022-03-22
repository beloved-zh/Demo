package com.beloved.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("/hello")
    public String hello() {
        // 获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        System.out.println("身份信息：" + user.getUsername());
        System.out.println("权限信息：" + authentication.getAuthorities());

        new Thread(() -> {
            Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
            User user1 = (User)authentication1.getPrincipal();
            System.out.println("t1身份信息：" + user1.getUsername());
            System.out.println("t1权限信息：" + authentication1.getAuthorities());
        }, "t1").start();

        return "Hello SpringSecurity！";
    }

}
