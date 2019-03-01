package com.test.replacemethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-01 09:28
 * @Version 1.0
 * @Description replaced-method
 */
public class TestChageMethod {
    public void changeMe(){
        System.out.println("changeMe");
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("replaceMethodTest.xml");
        TestChageMethod testChageMethod = (TestChageMethod) applicationContext.getBean("testChangeMethod");
        testChageMethod.changeMe();
    }
}
