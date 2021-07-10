package com.test.designMode.singleton.different;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-05 09:47
 * @description: 懒汉式，线程不安全
 **/
public class SingletonLazy {
    private static SingletonLazy instance;
    private SingletonLazy(){

    }
    public static SingletonLazy getInstance(){
        if (instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }
}
