package com.beloved.config;

import com.alibaba.fastjson.JSONObject;
import com.beloved.filter.LoginFilter;
import com.beloved.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        userDetailsManager.createUser(User.withUsername("admin").password("{noop}123").roles("admin").build());
//        return userDetailsManager;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        String encodingId = "MD5";
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("ldap", new org.springframework.security.crypto.password.LdapShaPasswordEncoder());
        encoders.put("MD4", new org.springframework.security.crypto.password.Md4PasswordEncoder());
        encoders.put("MD5", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("MD5"));
        encoders.put("noop", org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("SHA-1", new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-1"));
        encoders.put("SHA-256",
                new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-256"));
        encoders.put("sha256", new org.springframework.security.crypto.password.StandardPasswordEncoder());
        encoders.put("argon2", new Argon2PasswordEncoder());
        return new DelegatingPasswordEncoder(encodingId, encoders);
    }

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * ?????? AuthenticationManager ?????????
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // ????????? LoginFilter ??????
    @Bean
    public LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();

        // ???????????? url
        loginFilter.setFilterProcessesUrl("/login");

        // ???????????? key
        loginFilter.setUsernameParameter("uname");
        loginFilter.setPasswordParameter("pwd");

        loginFilter.setAuthenticationManager(authenticationManagerBean());

        // ?????????????????????
        loginFilter.setAuthenticationSuccessHandler(((request, response, authentication) -> {
            JSONObject result = new JSONObject();
            result.put("msg", "????????????");
            result.put("????????????", authentication.getPrincipal());
            response.setStatus(HttpStatus.OK.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println(result);
        }));

        // ?????????????????????
        loginFilter.setAuthenticationFailureHandler(((request, response, exception) -> {
            JSONObject result = new JSONObject();
            result.put("msg", "???????????????" + exception.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println(result);
        }));

        return loginFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated() //????????????????????????
                .and()
                .formLogin()
                .and()
                // ?????????????????????
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    JSONObject result = new JSONObject();
                    result.put("msg", "???????????????" + authException.getMessage());
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().println(result);
                })
                .and()
                .logout()
                .logoutUrl("/logout")
                // ??????????????????
                .logoutSuccessHandler(((request, response, authentication) -> {
                    JSONObject result = new JSONObject();
                    result.put("msg", "????????????");
                    result.put("????????????", authentication.getPrincipal());
                    response.setStatus(HttpStatus.OK.value());
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().println(result);
                }))
                .and()
                .csrf().disable();

        /*
         * addFilterAt????????????????????????????????? filter
         * addFilterBefore?????????????????????????????? filter ??????
         * addFilterAfter?????????????????????????????? filter ??????
         */
        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
