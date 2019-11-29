package com.test.spring.beanInit;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author myFlowerYourGrass
 * @Date 2019-10-18 09:18
 * @Version 1.0
 * @Description Bean的生命周期
 */
public class LifeCycleBean implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, BeanPostProcessor,
        InitializingBean, DisposableBean {
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        System.out.println("属性注入。。。。");
        this.test = test;
    }

    public LifeCycleBean() {
        System.out.println("构造函数调用...");
    }

    public void display(){
        System.out.println("方法调用...");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("BeanClassLoaderAware 调用...");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware 调用...");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware 调用...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy 被调用...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcess PostProcessBeforeInitialization 被调用...");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcess PostProcessAfterInitialization 被调用....");
        return o;
    }

    public void initMethod(){
        System.out.println("init-method 被调用...");
    }
    public void destroyMethod(){
        System.out.println("destroy-method 被调用....");
    }

    public static void main(String[] args) {
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("Initializing/initializing.xml"));
        beanFactory.addBeanPostProcessor(new LifeCycleBean());
        LifeCycleBean bean = (LifeCycleBean) beanFactory.getBean("lifeCycle");
        bean.display();
        System.out.println("方法调用完成，容器开始关闭......");
        //关闭容器
        beanFactory.destroySingletons();
    }
}
