package com.spring.ten.test;


import com.spring.po.User;
import com.spring.ten.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description
 * @author playboy
 * @date 2020-04-25 08:25
 * version 1.0
 */
@Slf4j
public class SpringJDBCTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext act = new ClassPathXmlApplicationContext("spring/ten/spring-config.xml");

		UserService userService = (UserService) act.getBean("userService");
		User user = new User("张三", 20, "男");
		userService.save(user);

	}

}
