package com.test.spring.aop.actualCombat;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description 使用该注解的controller需要进行调用方权限的认证
 * 用于注解requestMapping方法
 * @author playboy
 * @date 2020-03-16 16:43
 * version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthChecker {
}
