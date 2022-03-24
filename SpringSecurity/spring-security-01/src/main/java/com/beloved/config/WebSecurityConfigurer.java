package com.beloved.config;

import com.beloved.handler.MyAuthenticationFailureHandler;
import com.beloved.handler.MyAuthenticationSuccessHandler;
import com.beloved.handler.myLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    // 如果使用的是默认创建的 AuthenticationManager ，检测到 UserDetailsService 将自动使用
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        userDetailsService.createUser(User.withUsername("abc").password("{noop}123").roles("admin").build());
//        return userDetailsService;
//    }

    @Autowired
    private MyUserDetailsServer myUserDetailsServer;

    // SpringBoot 对 Security 默认配置中在工厂创建 AuthenticationManager
//    @Autowired
//    public void initialize(AuthenticationManagerBuilder builder) {
//        System.out.println("SpringBoot 自动配置：" + builder);
//    }

    // 完全自定义 AuthenticationManager    不会在工厂中暴露
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("自定义AuthenticationManager：" + auth);
        auth.userDetailsService(myUserDetailsServer);
    }

    // 将 AuthenticationManager 暴露在工厂中，在其余地方可以注入使用
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

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
                //.defaultSuccessUrl("/index", true)  // 无论请求之前是否有地址都进行重定向
                .successHandler(new MyAuthenticationSuccessHandler()) // 登录成功处理器  前后端分离处理方案
                //.failureForwardUrl("/login.html") // 认证失败后跳转 forward   异常信息作用域 request
                //.failureUrl("/login.html") // 认证失败后跳转 redirect 异常信息作用域 session
                .failureHandler(new MyAuthenticationFailureHandler())   // 自定义认证失败后处理
                .and()
                .logout() // 开启注销登录，获取到注销登录的对象
                //.logoutUrl("/logout") // 指定注销登录 url 默认必须 GET
                // 配置多个注销登录
                .logoutRequestMatcher(new OrRequestMatcher(
                        new AntPathRequestMatcher("/logout", "GET"),
                        new AntPathRequestMatcher("/abc", "POST")
                ))
                .invalidateHttpSession(true) // session 会话失效  默认：true
                .clearAuthentication(true) // 清除认证标记  默认：true
                //.logoutSuccessUrl("/login.html") // 注销登录成功后跳转地址
                .logoutSuccessHandler(new myLogoutSuccessHandler())  // 自定义注销登录成功后处理
                .and()
                .csrf().disable()   // 禁止 csrf 跨站请求攻击保护
        ;
    }
}
