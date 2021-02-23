package com.test.designMode.templateMethod;


/**
 * Description 茶
 *
 * @author playboy
 * @date 2020-01-17 11:26
 * version 1.0
 */
public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }


    public void steepTeaBag() {
        System.out.println("Steeping the tea");
    }

    public void addLemon() {
        System.out.println("Adding Lemon");
    }

}
