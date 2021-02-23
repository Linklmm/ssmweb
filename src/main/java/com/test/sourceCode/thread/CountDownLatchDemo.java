package com.test.sourceCode.thread;


import java.util.concurrent.CountDownLatch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Description CountDownLatch代码测试
 *
 * @author playboy
 * @date 2020-03-08 21:49
 * version 1.0
 */
@Slf4j
public class CountDownLatchDemo {
    /**
     * 线程任务
     */

    class Worker implements Runnable {
        //定义计数锁所用来实现让一组线程全部启动完成之后，再一起执行
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSiganl;

        public Worker(CountDownLatch startSignal, CountDownLatch doneSiganl) {
            this.startSignal = startSignal;
            this.doneSiganl = doneSiganl;
        }

        //子线程做的事情
        @Override
        public void run() {
            log.info("{} is begin", Thread.currentThread().getName());
            try {
                // await 时有两点需要注意：await 时 state 不会发生变化，
                // 2：startSignal 的state初始化是 1，所以所有子线程都是获取不到锁的，
                // 都需要到同步队列中去等待，达到先启动的子线程等待后面启动的子线程的结果
                startSignal.await();
                doWork();
                // countDown 每次会使 state 减一，doneSignal 初始化为 9，
                // countDown 前 8 次执行都会返回 false (releaseShared 方法)，执行第 9 次时，state 递减为 0，
                // 会 countDown 成功，表示所有子线程都执行完了，会释放 await 在 doneSignal 上的主线程
                doneSiganl.countDown();
                log.info("{} is end", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                log.info("startSignal happen exception");
            }

        }

        void doWork() throws InterruptedException {
            log.info("{} sleep 5s ......", Thread.currentThread().getName());
            Thread.sleep(5000);
        }

    }

    @Test
    public void test() throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(9);

        for (int i = 0; i < 9; i++) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }
        log.info("main is begin");
        // 这行代码唤醒 9 个子线程，开始执行(因为 startSignal 锁的状态是 1，所以调用一次 countDown 方法就可以释放9个等待的子线程)
        startSignal.countDown();
        // 这行代码使主线程陷入沉睡，等待 9 个子线程执行完成之后才会继续执行(就是等待子线程执行 doneSignal.countDown())
        doneSignal.await();
        log.info("main thread end");
    }

}
