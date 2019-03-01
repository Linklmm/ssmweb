package com.service;

import com.dao.UserDao;
import com.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
}
