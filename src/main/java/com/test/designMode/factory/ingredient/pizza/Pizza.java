package com.test.designMode.factory.ingredient.pizza;


import com.test.designMode.factory.ingredient.Cheese;
import com.test.designMode.factory.ingredient.Clams;
import com.test.designMode.factory.ingredient.Dough;
import com.test.designMode.factory.ingredient.Pepperoni;
import com.test.designMode.factory.ingredient.Sauce;
import com.test.designMode.factory.ingredient.Veggies;

import java.util.Arrays;

/**
 * Description 披萨基类
 *
 * @author playboy
 * @date 2020-01-08 09:08
 * version 1.0
 */
public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Veggies veggies[];
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clams clam;

    /**
     * 通过原料工厂获取原料
     */
    abstract void prepare();

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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", veggies=" + Arrays.toString(veggies) +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", clam=" + clam +
                '}';
    }

}
