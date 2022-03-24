package com.beloved.config;

import com.beloved.entity.Role;
import com.beloved.entity.User;
import com.beloved.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class MyUserDetailsServer implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 查询用户
        User user = userMapper.loadUserByUsername(username);

        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("用户不存在！！！");
        }

        // 查询角色
        List<Role> roles = userMapper.getRolesByUid(user.getId());
        user.setRoles(roles);

        return user;
    }
}
