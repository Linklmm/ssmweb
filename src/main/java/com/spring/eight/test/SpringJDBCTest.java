package com.spring.eight.test;


import com.alibaba.fastjson.JSON;
import com.spring.eight.pojo.User;
import com.spring.eight.service.UserService;
import java.util.List;
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
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("spring/eight/spring-config.xml");

		UserService userService = (UserService) act.getBean("userService");
		User user = new User("张三",20,"男");
		userService.save(user);

		List<User> users = userService.getUsers();
		log.info("users:{}",JSON.toJSONString(users));
	}
}
