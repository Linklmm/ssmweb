package com.test.spring.initializingBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author myFlowerYourGrass
 * @Date 2019-10-18 08:39
 * @Version 1.0
 * @Description 测试init-method 属性
 */
public class InitializingBeanTest2 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOtherName() {
        System.out.println("InitializingBeanTest setOtherName....");
        this.name = "chen yue peng 3 号";
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Initializing/initializing.xml");
        InitializingBeanTest2 test = (InitializingBeanTest2) applicationContext.getBean("initializingBean");
        System.out.println("name :" + test.getName());
    }
}
