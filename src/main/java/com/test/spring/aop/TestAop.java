package com.test.spring.aop;

import com.test.spring.aop.dao.Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author myFlowerYourGrass
 * @Date 2019-10-26 16:58
 * @Version 1.0
 * @Description 测试aop
 */
public class TestAop {

    public static void testAop(){
        ApplicationContext bf = new ClassPathXmlApplicationContext("aop/aop.xml");

        Dao dao = (Dao) bf.getBean("daoImpl");
        dao.select();
    }

    public static void main(String[] args) {
        testAop();
    }
}
