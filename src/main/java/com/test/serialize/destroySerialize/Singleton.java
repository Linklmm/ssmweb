package com.test.serialize.destroySerialize;


import java.io.Serializable;

import lombok.Data;

/**
 * Description 使用双重校验锁的方式创建单例
 *
 * @author playboy
 * @date 2020-04-27 11:10
 * version 1.0
 */
@Data
public class Singleton implements Serializable {
    private static final long serialVersionUID = -7815273380906643086L;
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 防止单例被序列化破坏
     *
     * @return
     */
    private Object readResolve() {
        return singleton;
    }
}
