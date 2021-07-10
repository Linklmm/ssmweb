package com.test.designMode.singleton.different;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-05 09:29
 * @description: 饿汉式单例
 * 这是个比较形象的比喻。对于一个饿汉来说，他希望他想要用到这个实例的时候就能够立即拿到，而不需要任何等待时间。
 * 所以，通过static的静态初始化方式，在该类第一次被加载的时候，就有一个SimpleSingleton的实例被创建出来了。
 * 这样就保证在第一次想要使用该对象时，他已经被初始化好了。
 * 同时，由于该实例在类被加载的时候就创建出来了，所以也避免了线程安全问题。
 **/
public class SingletonHungry {
    private static SingletonHungry singleton = new SingletonHungry();
    private SingletonHungry(){
    }

    public static SingletonHungry getSingleton(){
        return singleton;
    }
}
