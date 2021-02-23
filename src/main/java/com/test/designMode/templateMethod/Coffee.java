package com.test.designMode.templateMethod;


/**
 * Description 咖啡类
 *
 * @author playboy
 * @date 2020-01-17 11:23
 * version 1.0
 */
public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        //System.out.println("Dripping Coffee through filter");
        brewCoffeeGrinds();
    }

    @Override
    void addCondiments() {
        addSugarAndMilk();
    }


    public void brewCoffeeGrinds() {
        System.out.println("Dripping Coffee through filter");
    }


    public void addSugarAndMilk() {
        System.out.println("Adding sugar and Milk");
    }

}
