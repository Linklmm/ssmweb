package com.test.designMode.factory.Pizza;


/**
 * Description 披萨店类
 * @author playboy
 * @date 2020-01-06 14:33
 * version 1.0
 */
public class PizzaStore {
	SimplePizzaFactory factory;

	public PizzaStore(SimplePizzaFactory factory) {
		this.factory = factory;
	}

	public Pizza orderPizza(String type){
		Pizza pizza;
		pizza = factory.createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
