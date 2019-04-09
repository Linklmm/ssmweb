package com.test.effectivejava;

/**
 * @Auther: linklmm
 * @Date: 2019/4/9 14:47
 * @Description 构造器决不能调用可被覆盖的方法，无论是直接调用还是间接调用
 */
public class Super {
    public Super() {
    overrideMe();
    }
    public void overrideMe(){

    }
}
