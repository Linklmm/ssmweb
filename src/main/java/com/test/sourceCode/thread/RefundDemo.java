package com.test.sourceCode.thread;


import lombok.extern.slf4j.Slf4j;

/**
 * Description 模拟单个商品退款代码
 *
 * @author playboy
 * @date 2020-03-09 09:55
 * version 1.0
 */
@Slf4j
public class RefundDemo {
    /**
     * 根据商品ID进行退款
     *
     * @param itemId
     * @return
     */
    public boolean refundByItem(Long itemId) {
        try {
            //模拟商品退款
            Thread.sleep(30);
            log.info("refund successs,itemId is {}", itemId);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.info("happen exception ,message is {}", e.getMessage());
        }
        return false;
    }

}
