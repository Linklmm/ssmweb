package com.test.event;

import org.springframework.context.ApplicationEvent;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-13 11:22
 * @Version 1.0
 * @Description spring的事件监听的简单用法
 */
public class TestEvent extends ApplicationEvent {
    public String msg;

    public TestEvent(Object source) {
        super(source);
    }

    public TestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public void print() {
        System.out.println(msg);
    }
}
