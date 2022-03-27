package com.beloved.service;

import com.beloved.entity.User;
import com.beloved.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class MyUserDetailsService implements UserDetailsService, UserDetailsPasswordService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("用户不存在！！！");
        }

        user.setRoles(userMapper.getRolesByUid(user.getId()));

        return user;
    }

    @Override
    public UserDetails updatePassword(UserDetails userDetails, String newPassword) {
        User user = (User)userDetails;
        Integer i = userMapper.updatePassword(user.getId(), newPassword);

        if (i == 1) {
            user.setPassword(newPassword);
        }

        return user;
    }
}
