package com.test.designMode.proxy;


import lombok.Data;

/**
 * Description 糖果类
 *
 * @author playboy
 * @date 2020-03-15 10:01
 * version 1.0
 */
@Data
public class GumballMachine {
    private String location;
    private String state;
    private int count;

    public GumballMachine(String location, int count) {
        this.location = location;
        this.count = count;
    }

    public GumballMachine() {
    }

}
