package com.test.designMode.factory.pizza2;


import com.test.designMode.factory.Pizza.Pizza;

/**
 * Description 纽约披萨
 * @author playboy
 * @date 2020-01-06 15:25
 * version 1.0
 */
public class NYStyleCheesePizza extends Pizza {
	public NYStyleCheesePizza() {
		name ="NY Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		toppings.add("Grated Reggiano Cheese");
	}

}
