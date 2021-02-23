package com.test.sourceCode.thread;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Description 使用CountDownLatch进行批量退款
 *
 * @author playboy
 * @date 2020-03-09 09:58
 * version 1.0
 */
@Slf4j
public class BatchRefundDemo {
    //	定义线程池
    public static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(10, 10,
            0, TimeUnit.MILLISECONDS
            , new LinkedBlockingDeque<>(20));

    @Test
    public void batchRefund() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(30);
        RefundDemo refundDemo = new RefundDemo();

        //准备30个商品
        List<Long> items = Lists.newArrayListWithCapacity(30);
        for (int i = 0; i < 30; i++) {
            items.add(Long.valueOf(i + ""));
        }
        System.currentTimeMillis();
        //准备开始批量退款
        List<Future> futures = Lists.newArrayListWithCapacity(30);
        for (Long item : items) {
            Future<Boolean> future = EXECUTOR_SERVICE.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    boolean result = refundDemo.refundByItem(item);
                    countDownLatch.countDown();
                    return result;
                }
            });
            futures.add(future);
        }

        log.info("30个商品已经在退款");
        //使主线程阻塞，一直等待30个商品都退款完成，才能继续执行。
        countDownLatch.await();
        //拿到结果进行分析
        List<Boolean> result = futures.stream().map(future -> {
            try {
                return (Boolean) future.get(1, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());

        long success = result.stream().filter(r -> r.equals(true)).count();
        log.info("执行结果成功：{}，失败：{}", success, result.size() - success);
    }

}
