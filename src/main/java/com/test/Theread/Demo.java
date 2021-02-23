package com.test.Theread;


import java.util.concurrent.ArrayBlockingQueue;

import lombok.extern.slf4j.Slf4j;

/**
 * Description 通过声场这消费者模式演示volatile的局限性，volatile不能唤醒已经阻塞的线程，
 * 生产者生产速度很快，消费者消费速度很慢，通过阻塞队列存储商品
 *
 * @author playboy
 * @date 2020-06-18 07:49
 * version 1.0
 */
@Slf4j
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(5);

        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        //1s足够让生产者把阻塞队列塞满
        Thread.sleep(1000);

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()) {
            log.error(storage.take() + "被消费");
            Thread.sleep(100);
        }

        log.error("消费者消费完毕");
        //让生产者停止生产（实际情况是不行的，因为此时生产者处于阻塞状态，volatile不能唤醒阻塞状态的线程）
        producer.canceled = true;
        log.error(producerThread.getState().name());
    }

}
