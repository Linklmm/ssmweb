package com.spring.ten.service;


import com.spring.po.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description 创建数据操作接口
 * @author playboy
 * @date 2020-05-11 08:55
 * version 1.0
 */
@Transactional(propagation = Propagation.REQUIRED)
public interface UserService {
	public void save(User user) throws Exception;
}
