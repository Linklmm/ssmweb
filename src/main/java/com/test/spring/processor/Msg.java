package com.test.spring.processor;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-13 10:16
 * @Version 1.0
 * @Description 测试
 */
public class Msg {
    private String message;

    @Override
    public String toString() {
        return "Msg:" + this.message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
