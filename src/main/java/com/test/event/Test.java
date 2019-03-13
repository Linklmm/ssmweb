package com.test.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-13 11:28
 * @Version 1.0
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("event/eventlistener.xml");

        TestEvent event = new TestEvent("hello","msg");
        context.publishEvent(event);
    }
}
