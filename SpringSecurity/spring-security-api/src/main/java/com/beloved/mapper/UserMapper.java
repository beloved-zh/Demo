package com.beloved.mapper;

import com.beloved.entity.Role;
import com.beloved.entity.User;

import java.util.List;

public interface UserMapper {

    // 根据用户名返回用户
    User loadUserByUsername(String username);

    // 根据用户id查询角色
    List<Role> getRolesByUid(Integer uid);

    // 修改用户密码
    Integer updatePassword(Integer uid, String password);
}
