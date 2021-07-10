package com.test.designMode.singleton.different;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-05 09:49
 * @description: 懒汉式，线程安全
 **/
public class SingletonLazySafe {
    private static SingletonLazySafe singleton;
    private SingletonLazySafe(){}

    public static synchronized SingletonLazySafe getSingleton(){
        if (singleton == null){
            singleton = new SingletonLazySafe();
        }
        return singleton;
    }
}
