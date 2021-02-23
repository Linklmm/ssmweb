package com.test.sourceCode.queue;


import java.util.concurrent.LinkedBlockingDeque;

import org.junit.jupiter.api.Test;

/**
 * Description 查看LinkedBlockingQUeue的源码
 *
 * @author playboy
 * @date 2020-02-27 10:36
 * version 1.0
 */
public class TestLinkedBlockingQueue {
    @Test
    public void testTake() throws InterruptedException {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque(2);
        linkedBlockingDeque.add("nihao");
        linkedBlockingDeque.add("nihao2");
        String s = (String) linkedBlockingDeque.take();
        System.out.println(s);
    }
}
