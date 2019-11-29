package com.test.spring.customtag.test;

import com.test.spring.customtag.pojo.Student;
import com.test.spring.customtag.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-02 16:50
 * @Version 1.0
 * @Description 测试自定义标签
 */
public class TestCustomtag {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("customtag/customtag.xml");
        User user = (User) applicationContext.getBean("testBean");
        System.out.println(user.getUserName() + "," + user.getEmail());

        Student student = (Student) applicationContext.getBean("studentBean");
        System.out.println(student.getStudentName() + "," + student.getClassName());
    }
}
