package com.test.designMode.factory.pizza2;


import com.test.designMode.factory.Pizza.Pizza;

/**
 * Description 纽约披萨店
 *
 * @author playboy
 * @date 2020-01-06 14:56
 * version 1.0
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else {
            return null;
        }
    }

}
