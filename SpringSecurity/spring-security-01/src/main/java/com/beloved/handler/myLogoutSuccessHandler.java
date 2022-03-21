package com.beloved.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义注销登录处理器
 */
public class myLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "注销成功");
        result.put("authentication", authentication);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(result);
    }
}
