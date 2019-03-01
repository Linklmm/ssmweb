package com.service.impl;

import com.controller.UserController;
import com.dao.UserDao;
import com.model.User;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private Logger log=Logger.getLogger(UserController.class);
    @Resource
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        //System.out.println("dao");
        log.info("getAllUser");
        return userDao.selectAllUser();
    }
}
