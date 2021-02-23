package com.test.designMode.factory.pizza2;


import com.test.designMode.factory.Pizza.Pizza;

/**
 * Description 测试类
 *
 * @author playboy
 * @date 2020-01-06 15:35
 * version 1.0
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName());

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName());
    }
}
