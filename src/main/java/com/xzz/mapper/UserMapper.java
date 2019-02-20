package com.xzz.mapper;

import com.xzz.pojo.User;

import java.util.List;

public interface UserMapper {
    //根据id查询一个账户
    User findUserById( int id);

    //查询所有账户
    List<User> findAllUser();
}
