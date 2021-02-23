package com.spring.night.testMybatis;


import com.alibaba.fastjson.JSON;
import com.spring.night.dao.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description spring和mybatis的整合
 *
 * @author playboy
 * @date 2020-05-03 10:03
 * version 1.0
 */
@Slf4j
public class UserServiceTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/night/two/Application.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        log.info("{}", JSON.toJSONString(userMapper.getUser(1)));
    }
}
