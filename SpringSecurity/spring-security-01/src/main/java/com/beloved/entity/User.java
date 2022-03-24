package com.beloved.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Getter
    private Integer id;

    // 用户名
    private String username;

    // 密码
    private String password;

    // 账号是否激活
    private Boolean enable;

    // 账号是否过期
    private Boolean accountNonExpired;

    // 账号是否锁定
    private Boolean accountNonLocked;

    // 密码是否过期
    private Boolean credentialsNonExpired;

    // 用户所属角色
    @Getter
    private List<Role> roles = new ArrayList<>();

    // 返回权限信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        roles.forEach(role -> {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorities.add(simpleGrantedAuthority);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}
