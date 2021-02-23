package com.test.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-13 11:25
 * @Version 1.0
 * @Description 定义监听器
 */
public class TestListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof TestEvent) {
            TestEvent testEvent = (TestEvent) applicationEvent;
            testEvent.print();
            System.out.println("我监听到了");
        }
    }
}
