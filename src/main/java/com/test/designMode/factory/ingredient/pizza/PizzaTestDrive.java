package com.test.designMode.factory.ingredient.pizza;


/**
 * Description 测试类
 * @author playboy
 * @date 2020-01-06 15:35
 * version 1.0
 */
public class PizzaTestDrive {
	public static void main(String[] args) {
		NYPizzaStore nyStore = new NYPizzaStore();

		Pizza pizza = nyStore.createPizza("cheese");
		System.out.println("Ethan ordered a "+pizza.getName());

	}
}
