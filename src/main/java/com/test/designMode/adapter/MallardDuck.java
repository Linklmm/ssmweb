package com.test.designMode.adapter;


/**
 * Description 绿头鸭类
 *
 * @author playboy
 * @date 2020-01-15 15:14
 * version 1.0
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }

}
