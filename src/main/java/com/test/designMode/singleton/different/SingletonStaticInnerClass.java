package com.test.designMode.singleton.different;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-05 09:51
 * @description: 静态内部类
 **/
public class SingletonStaticInnerClass {
    private static class SingletonHolder {
        private static final SingletonStaticInnerClass INSTANCE = new SingletonStaticInnerClass();
    }

    private SingletonStaticInnerClass() {
    }

    public static final SingletonStaticInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
