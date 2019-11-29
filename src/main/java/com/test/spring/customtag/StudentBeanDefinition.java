package com.test.spring.customtag;

import com.test.spring.customtag.pojo.Student;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-04 11:19
 * @Version 1.0
 * @Description 解析XSD文件中的定义和组件定义
 */
public class StudentBeanDefinition extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return Student.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String studentName = element.getAttribute("studentName");
        String className = element.getAttribute("className");

        if (StringUtils.hasText(studentName)) {
            builder.addPropertyValue("studentName", studentName);
        }
        if (StringUtils.hasText(className)) {
            builder.addPropertyValue("className", className);
        }
    }
}
