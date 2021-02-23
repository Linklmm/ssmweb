package com.spring.eight.service;


import com.spring.eight.pojo.User;

import java.util.List;

/**
 * Description
 *
 * @author playboy
 * @date 2020-04-25 08:09
 * version 1.0
 */
public interface UserService {
    public void save(User user);

    List<User> getUsers();
}
