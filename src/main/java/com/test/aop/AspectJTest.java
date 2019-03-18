package com.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-13 16:32
 * @Version 1.0
 * @Description AspectJ注解测试
 */
@Component
@Aspect
public class AspectJTest {
    @Pointcut("execution(* *.test(..))")
    public void test(){

    }
    @Before("test()")
    public void beforeTest(){
        System.out.println("beforeTest");
    }
    @After("test()")
    public void afterTest(){
        System.out.println("afterTest");
    }

    @Around("test()")
    public Object arroundTest(ProceedingJoinPoint p){
        System.out.println("before1");
        Object o = null;
        try {
            o=p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("aop/static-aop.xml");
        TestBean testBean = (TestBean) bf.getBean("test");
        testBean.test();
    }
}
