package com.test.sourceCode.queue;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Description 查看SynchronousQueue的源码
 *
 * @author playboy
 * @date 2020-02-27 15:31
 * version 1.0
 */
@Slf4j
public class TestSynchronousQueue {
    @Test
    public void test() {
        SynchronousQueue queue = new SynchronousQueue();
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            es.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("进入线程,ThreadName:{}", Thread.currentThread().getName());
                    if (finalI % 2 == 0) {
                        try {
                            log.info("开始put");
                            queue.put(finalI);
                        } catch (InterruptedException e) {
                            log.info("put异常");
                        }
                    } else {
                        log.info("开始take");
                        try {
                            queue.take();
                        } catch (InterruptedException e) {
                            log.info("开始take");
                        }
                    }
                }
            });
        }


    }

}
