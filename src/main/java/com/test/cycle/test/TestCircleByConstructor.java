package com.test.cycle.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-05 13:33
 * @Version 1.0
 * @Description 构造器循环依赖测试
 */
public class TestCircleByConstructor {
    public  void testCircleByConsturctor()throws Throwable {
        try {
            new ClassPathXmlApplicationContext("cycle/cycle-test1.xml");
        } catch (BeansException e) {
            Throwable el = e.getCause().getCause().getCause();
            throw el;
        }
    }
    public void testCircleBySetterAndPrototype() throws Throwable {
        try {
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("cycle/cycle-test2.xml");
            System.out.println(applicationContext.getBean("testA"));
        } catch (BeansException e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

    public static void main(String[] args) throws Throwable {
        TestCircleByConstructor testCircleByConstructor = new TestCircleByConstructor();
//        testCircleByConstructor.testCircleByConsturctor();
        testCircleByConstructor.testCircleBySetterAndPrototype();
    }

}
