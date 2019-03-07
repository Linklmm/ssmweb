package com.test.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-07 17:20
 * @Version 1.0
 * @Description 测试beanFactoryAware
 */
public class TestBeanFactoryAware implements BeanFactoryAware {
    private BeanFactory beanFactory;
    //声明bean的时候spring会自动注入beanfactory
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
    public void testAware(){
        Hello hello = (Hello) beanFactory.getBean("hello");
        hello.say();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestBeanFactoryAware test = (TestBeanFactoryAware) ctx.getBean("test");
        test.testAware();
    }
}
