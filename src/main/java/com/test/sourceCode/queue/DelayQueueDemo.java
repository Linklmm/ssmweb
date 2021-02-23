package com.test.sourceCode.queue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Description DelayQueue源码分析
 *
 * @author playboy
 * @date 2020-03-01 21:50
 * version 1.0
 */
@Slf4j
public class DelayQueueDemo {
    //队列消息的生产者
    static class Product implements Runnable {
        private final BlockingQueue queue;

        public Product(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            log.info("begin put");
            long beginTime = System.currentTimeMillis();
            try {
                queue.put(new DelayedDTO(System.currentTimeMillis() + 2000L, beginTime));
                queue.put(new DelayedDTO(System.currentTimeMillis() + 5000L, beginTime));
                queue.put(new DelayedDTO(System.currentTimeMillis() + 1000L * 10, beginTime));
                log.info("end put");
            } catch (InterruptedException e) {
                log.error("异常信息:{}", e.getMessage());
            }
        }

    }

    //队列的消费者
    static class Consumer implements Runnable {
        private final BlockingQueue queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            log.info("Consumer begin");
            try {
                ((DelayedDTO) queue.take()).run();
                ((DelayedDTO) queue.take()).run();
                ((DelayedDTO) queue.take()).run();
                log.info("Consumer end");
            } catch (InterruptedException e) {
                log.error("" + e);
            }
        }

    }

    @Data
    //队列元素，实现Delayed接口
    static class DelayedDTO implements Delayed {
        Long s;
        Long beginTime;

        public DelayedDTO(Long s, Long beginTime) {
            this.s = s;
            this.beginTime = beginTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(s - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        public void run() {
            log.info("现在已经经过了{}秒钟", (System.currentTimeMillis() - beginTime) / 1000);
        }

    }

    public static void main(String[] args) {
        BlockingQueue q = new DelayQueue();
        DelayQueueDemo.Product p = new DelayQueueDemo.Product(q);
        DelayQueueDemo.Consumer c = new DelayQueueDemo.Consumer(q);
        new Thread(c).start();
        new Thread(p).start();
    }

}
