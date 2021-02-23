package com.test.designMode.singleton;


/**
 * Description 单例模式
 *
 * @author playboy
 * @date 2020-01-10 08:52
 * version 1.0
 */
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
