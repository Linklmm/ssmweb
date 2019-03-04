package com.test.customtag;

import com.test.customtag.pojo.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-02 16:24
 * @Version 1.0
 * @Description 实现BeanDefinitionParser, 用来解析XSD文件中的定义和组件定义
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    //    element对应的类
    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    //从Element中解析并提取对应的元素
    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String userName = element.getAttribute("userName");
        String email = element.getAttribute("email");
        //将提取的数据放入到BeanDefinitionBuilder中，待到完成所有bean的解析后统一注册到beanfactory中
        if (StringUtils.hasText(userName)) {
            builder.addPropertyValue("userName", userName);
        }
        if (StringUtils.hasText(email)) {
            builder.addPropertyValue("email", email);
        }
    }
}
