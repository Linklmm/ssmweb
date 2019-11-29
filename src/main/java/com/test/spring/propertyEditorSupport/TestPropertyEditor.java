package com.test.spring.propertyEditorSupport;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-11 09:37
 * @Version 1.0
 * @Description 测试自定义属性编辑器
 */
public class TestPropertyEditor {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("propertyEditor/propertyEditor.xml");
        UserManager userManager = (UserManager) context.getBean("userManager");
        System.out.println(userManager);
    }
}
