package com.test.spring.ch04;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-11 17:28
 * @Version 1.0
 * @Description 自定义BeanFactoryPostProcessor的创建及使用
 */
public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    private Set<String> obscenties;

    public ObscenityRemovingBeanFactoryPostProcessor() {
        this.obscenties = new HashSet<String>();
    }

    public Set<String> getObscenties() {
        return obscenties;
    }

    public void setObscenties(Set<String> obscenties) {
        this.obscenties.clear();
        for (String obscenity:obscenties) {
            this.obscenties.add(obscenity.toUpperCase());
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String beanName: beanNames){
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
            StringValueResolver valueResolver = new StringValueResolver() {
                @Override
                public String resolveStringValue(String s) {
                    if (isObscene(s)) return "*****";
                    return s;
                }
            };
            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
            visitor.visitBeanDefinition(bd);
        }
    }

    public boolean isObscene(Object value){
        String potentialObscenity = value.toString().toUpperCase();
        return this.obscenties.contains(potentialObscenity);
    }
}
