package com.test.spring.factorybean.test;

import com.test.spring.factorybean.pojo.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-02 16:50
 * @Version 1.0
 * @Description 测试factorybean
 */
public class TestFactoryBean {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("factorybean/car-factorybean.xml");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car.getBrand() + ";" + car.getMaxSpeed() + ";" + car.getPrice());
    }
}
