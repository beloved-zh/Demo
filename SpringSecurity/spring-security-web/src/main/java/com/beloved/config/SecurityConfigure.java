package com.beloved.config;

import com.beloved.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 自定义 Security 配置
 */
@Configuration
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/goLogin").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/goLogin")
                .loginProcessingUrl("/login")
                .usernameParameter("uname")
                .passwordParameter("pwd")
                .defaultSuccessUrl("/index", true)
                .failureUrl("/goLogin")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/goLogin")
                .and()
                .csrf().disable();
    }
}
