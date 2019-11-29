package com.test.spring.aop;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author myFlowerYourGrass
 * @Date 2019-10-26 16:52
 * @Version 1.0
 * @Description 用于方法调用前后打印时间，在aop中，扮演的是横切关注点的角色
 */
public class TimeHandler {
    public void printTime(){
        System.out.println("CurrentTime: "+System.currentTimeMillis());
    }
}
