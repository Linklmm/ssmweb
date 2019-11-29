package com.test.spring.customtag;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-02 16:35
 * @Version 1.0
 * @Description 将组件注册到spring容器
 */
public class MyNamespaceHandlerSupport extends org.springframework.beans.factory.xml.NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
        registerBeanDefinitionParser("student", new StudentBeanDefinition());
    }
}
