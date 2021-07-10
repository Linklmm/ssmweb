package com.test.designMode.singleton.different;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-05 09:31
 * @description: 饿汉式变种
 * 饿汉式单例，在类被加载的时候对象就会实例化。
 * 这也许会造成不必要的消耗，因为有可能这个实例根本就不会被用到。
 * 而且，如果这个类被多次加载的话也会造成多次实例化。其实解决这个问题的方式有很多，下面提供两种解决方式，第一种是使用静态内部类的形式。
 **/
public class SingletonHungry2 {
    private static SingletonHungry2 singleton;
    static {
        singleton = new SingletonHungry2();
    }
    private SingletonHungry2(){}

    public static SingletonHungry2 getInstance(){
        return singleton;
    }
}
