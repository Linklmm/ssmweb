package com.test.designMode.factory.Pizza;


import java.util.ArrayList;

/**
 * Description 披萨的基本接口
 *
 * @author playboy
 * @date 2020-01-06 14:23
 * version 1.0
 */
public abstract class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;
    protected ArrayList toppings = new ArrayList();

    public void prepare() {
        System.out.println("preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(" " + toppings.get(i));
        }
    }

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public String getName() {
        return name;
    }

}
