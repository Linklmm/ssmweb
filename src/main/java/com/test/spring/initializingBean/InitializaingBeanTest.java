package com.test.spring.initializingBean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @author myFlowerYourGrass
 * @Date 2019-10-17 08:53
 * @Version 1.0
 * @Description InitializingBean测试
 */
public class InitializaingBeanTest implements InitializingBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBeanTest initializing......");
        this.name = "chen yue peng 2 号";
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Initializing/initializing.xml");
        InitializaingBeanTest test = (InitializaingBeanTest) applicationContext.getBean("InitializingBeanTest");
        System.out.println("name :"+test.getName());
    }
}
