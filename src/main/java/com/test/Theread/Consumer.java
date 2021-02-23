package com.test.Theread;


import java.util.concurrent.BlockingQueue;

/**
 * Description 消费者
 *
 * @author playboy
 * @date 2020-06-18 08:10
 * version 1.0
 */
public class Consumer {
    private BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums() {
        return Math.random() < 0.95 ? true : false;
    }

}
