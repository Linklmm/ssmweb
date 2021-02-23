package com.test.sourceCode.queue.DivQueue;


import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * Description 测试自定义队列
 *
 * @author playboy
 * @date 2020-03-05 09:20
 * version 1.0
 */
@Slf4j
public class DIYQueueDemo {
    private final static Queue<String> QUEUE = new DIYQueue<String>();


    //生产者
    static class Product implements Runnable {
        private final String message;

        public Product(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            try {
                boolean success = QUEUE.put(message);
                if (success) {
                    log.info("queue put is success");
                } else {
                    log.info("queue put is fail");
                }
            } catch (Exception e) {
                log.info("Product is happen exception");
            }
        }

    }


    //消费者
    static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                String item = QUEUE.take();
                if (StringUtils.isEmpty(item)) {
                    log.info("queue take is fail");
                } else {
                    log.info("queue take is success ,item is {}", item);
                }
            } catch (Exception e) {
                log.info("Consumer is happen exception");
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0 || i % 3 == 0) {
                executor.submit(new Product(i + " "));
                continue;
            }
            executor.submit(new Consumer());
        }
        Thread.sleep(1000);
    }

}
