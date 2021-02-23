package com.test.sourceCode.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Description 测试线程
 *
 * @author playboy
 * @date 2020-03-05 11:08
 * version 1.0
 */
@Slf4j
public class MyThread extends Thread {
    /**
     * 共享变量1和2
     */
    private static final Object share1 = new Object();
    private static final Object share2 = new Object();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        log.info(Thread.currentThread().getName());
        myThread.start();
    }

    @Test
    public void testJoin() throws InterruptedException {
        Thread main = Thread.currentThread();
        log.info("{} is run", main.getName());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("{} is run", Thread.currentThread().getName());
                try {
                    Thread.sleep(30000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("{} is end", Thread.currentThread().getName());
            }
        });
        //开子线程执行任务
        thread.start();
        thread.join();
        log.info("{} is end ", Thread.currentThread().getName());

    }

    /**
     * 测试线程中断
     */
    @Test
    public void testInterrupt() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("{} is run", Thread.currentThread().getName());
                try {
                    log.info("{} is sleep 30s", Thread.currentThread().getName());
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    log.info("{} is interrupt", Thread.currentThread().getName());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        //主线程等待10s，然后打断子线程
        log.info("{} is sleep 10s", Thread.currentThread().getName());
        Thread.sleep(10000);
        thread.interrupt();
    }

    @Test
    public void testThreadPoolExecutor() throws ExecutionException, InterruptedException {
        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public String call() throws Exception {
                log.info("{} is run", Thread.currentThread().getName());
                Thread.sleep(3000);
                return "我是子线程：" + Thread.currentThread().getName();
            }
        });
        executor.submit(futureTask);
        String result = (String) futureTask.get();
        log.info("result:{}", result);

    }

    /**
     * 线程打印输出
     */
    @Test
    public void testMyThreadPoolExecutor() {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    log.info("我是子线程：{},输出：{}", Thread.currentThread().getName(), finalI);
                }
            });
            thread.start();
        }
    }

    /**
     * 测试Callable
     */
    @Test
    public void testFutureTask() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable() {
            @Override
            public String call() throws Exception {
                log.info("启动子线程:{}", Thread.currentThread().getName());
                return "我是子线程:" + Thread.currentThread().getName();
            }
        });
        new Thread(futureTask).start();
        log.info("子线程返回的结果：{}", futureTask.get());
    }

    /**
     * 测试join
     */
    @Test
    public void testJoin2() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("子线程1启动");
                log.info("{} is sleep 10s", Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    log.info("thread happen exception");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("子线程2启动");
                log.info("我是子线程:{}，我在等线程1", Thread.currentThread().getName());
                try {
                    thread1.join();
                    log.info("我是子线程2，子线程1执行完成，我继续执行");
                } catch (InterruptedException e) {
                    log.info("join happen exception!");
                }
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(20000);
    }

    /**
     * 测试死锁
     */
    @Test
    public void testDeadThread() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            //锁定共享变量share1
            log.info("线程1：{},锁定share1", Thread.currentThread().getName());
            synchronized (share1) {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("线程1{},锁定share1", Thread.currentThread().getName());
            }
            log.info("线程1：{},锁定share2", Thread.currentThread().getName());
            //锁定共享变量share2
            synchronized (share2) {
                log.info("线程1{}，锁定share2", Thread.currentThread().getName());
            }
        });

        Thread thread2 = new Thread(() -> {
            log.info("线程2：{},锁定share2", Thread.currentThread().getName());
            //锁定共享变量share2
            synchronized (share2) {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("线程2{},锁定share2", Thread.currentThread().getName());
            }
            log.info("线程2：{},锁定share1", Thread.currentThread().getName());
            //锁定共享变量share1
            synchronized (share1) {
                log.info("线程2{}，锁定share1", Thread.currentThread().getName());
            }
        });

        thread1.start();
        thread2.start();

        Thread.sleep(100000);

    }

}
