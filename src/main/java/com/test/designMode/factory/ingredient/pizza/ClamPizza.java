package com.test.designMode.factory.ingredient.pizza;


import com.test.designMode.factory.ingredient.PizzaIngredientFactory;

/**
 * Description
 * @author playboy
 * @date 2020-01-08 11:31
 * version 1.0
 */
public class ClamPizza extends Pizza {
	private PizzaIngredientFactory factory;

	public ClamPizza(PizzaIngredientFactory factory) {
		this.factory = factory;
	}

	@Override
	void prepare() {
		System.out.println("Preparing "+name);
		dough = factory.createDough();
		sauce = factory.createSauce();
		cheese = factory.createCheese();
		clam = factory.createClam();
	}

}
