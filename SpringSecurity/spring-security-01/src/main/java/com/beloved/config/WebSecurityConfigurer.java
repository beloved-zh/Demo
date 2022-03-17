package com.beloved.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/index","/login.html").permitAll()  // 放行资源要写在认证之前
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")   // 指定登录页面
                .loginProcessingUrl("/doLogin") // 指定了自定义登录页面必须指定登录请求地址
                .usernameParameter("uname").passwordParameter("pwd") // 指定表单字段名
                //.successForwardUrl("/index") // 认证成功跳转地址    forward
                //.defaultSuccessUrl("/index")   // 认证成功跳转地址    redirect 重定向  注意：请求之前有地址，会有优先跳转之前的地址
                .defaultSuccessUrl("/index", true)  // 无论请求之前是否有地址都进行重定向
                .and()
                .csrf().disable()   // 禁止 csrf 跨站请求攻击保护
        ;
    }
}
