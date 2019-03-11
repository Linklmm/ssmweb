package com.test.distConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-11 17:18
 * @Version 1.0
 * @Description
 */
public class TestMessage {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloMessage message = (HelloMessage) context.getBean("message");
        System.out.println(message.getMes());
    }
}
