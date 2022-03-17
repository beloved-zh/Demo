package com.beloved.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义认证成功处理Handler
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "登录成功");
        result.put("authentication", authentication);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(result);
    }
}
