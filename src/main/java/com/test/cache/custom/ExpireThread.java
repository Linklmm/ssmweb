package com.test.cache.custom;


import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * Description 过期缓存检测线程
 *
 * @author playboy
 * @date 2020-05-18 10:24
 * version 1.0
 */
@Slf4j
public class ExpireThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                log.info("过期缓存检测线程有问题:{}" + ExpireThread.class.getName());
            }
        }
    }

    /**
     * 缓存过期检测
     */
    public void expire() {
        for (String key : CacheGlobal.concurrentHashMap.keySet()) {
            CacheValue value = CacheGlobal.concurrentHashMap.get(key);
            //当前时间-创建时间
            long timeoutTime = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - value.getCreateTime());
            if (value.getExpireTime() > timeoutTime) {
                //没过期
                continue;
            }
            log.error("该缓存已过期，key为:{}", key);
            CacheGlobal.concurrentHashMap.remove(key);
        }
    }

}
