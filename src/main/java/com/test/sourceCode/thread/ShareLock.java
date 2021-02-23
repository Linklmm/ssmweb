package com.test.sourceCode.thread;


import java.io.Serializable;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

/**
 * Description 自定义共享不公平锁
 *
 * @author playboy
 * @date 2020-03-09 11:04
 * version 1.0
 */
@Slf4j
public class ShareLock implements Serializable {
    //同步器
    private final Sync sync;
    private final int maxCount;

    public ShareLock(int maxCount) {
        this.sync = new Sync(maxCount);
        this.maxCount = maxCount;
    }

    class Sync extends AbstractQueuedSynchronizer {
        public Sync(int count) {
            setState(count);
        }

        //获得i个锁
        public boolean acquireByShared(int i) {
            //自旋保证CAS 一定可以成功
            for (; ; ) {
                if (i <= 0) {
                    return false;
                }
                int state = getState();
                //如果没有锁可以获得，直接返回false
                if (state <= 0) {
                    return false;
                }
                int expectState = state - i;
                // 如果要得到的锁不够了，直接返回 false
                if (expectState < 0) {
                    return false;
                }

                //CAS尝试得到锁，CAS成功获得锁，失败继续for循环
                if (compareAndSetState(state, expectState)) {
                    return true;
                }
            }
        }

        /**
         * 释放i个锁
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            for (; ; ) {
                if (arg <= 0) {
                    return false;
                }
                int state = getState();
                int expectState = state + arg;
                if (expectState < 0 || expectState > maxCount) {
                    log.info("state 超过预期，当前 state is {},计算出的state is {}", state, expectState);
                    return false;
                }
                if (compareAndSetState(state, expectState)) {
                    return true;
                }

            }
        }

    }

    /**
     * 获得锁
     */
    public boolean lock() {
        return sync.acquireByShared(1);
    }

    /**
     * 释放锁
     */
    public boolean unlock() {
        return sync.tryRelease(1);
    }

}
