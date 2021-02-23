package com.test.designMode.decorate;


/**
 * Description 测试装饰者模式
 *
 * @author playboy
 * @date 2019-12-25 08:49
 * version 1.0
 */
public class StarbuzzCoffe {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
