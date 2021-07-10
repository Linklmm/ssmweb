package com.test.designMode.singleton.different;

import java.io.Serializable;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-05 09:43
 * @description: 双重校验锁单例模式
 * 序列化会对单例破坏，所以需要类中定义readResolve
 **/
public class DoubleCheckSingleton implements Serializable {
    private static final long serialVersionUID = 8464201380358635920L;
    private volatile static DoubleCheckSingleton singleton;
    private DoubleCheckSingleton(){}
    public static DoubleCheckSingleton getSingleton(){
        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class){
                if (singleton == null){
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }

    /**8
     * 解决序列化导致的单例模式失效
     * @return
     */
    private Object readResolve(){
        return singleton;
    }

}
