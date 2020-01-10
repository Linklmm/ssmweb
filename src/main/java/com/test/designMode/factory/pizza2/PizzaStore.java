package com.test.designMode.factory.pizza2;


import com.test.designMode.factory.Pizza.Pizza;

/**
 * Description 披萨店抽象类
 * @author playboy
 * @date 2020-01-06 14:43
 * version 1.0
 */
public abstract class PizzaStore {
	public Pizza orderPizza(String type){
		Pizza pizza;
		pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
	public abstract Pizza createPizza(String type);
}
