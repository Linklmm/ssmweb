package com.spring.night.dao;


import com.spring.po.User;

/**
 * Description 用户数据dao层
 * @author playboy
 * @date 2020-04-22 14:58
 * version 1.0
 */

public interface UserMapper {
	public void insertUser(User user);
	User getUser(Integer id);

}
