package com.test.designMode.factory.ingredient;


/**
 * Description 披萨原料工厂接口
 * @author playboy
 * @date 2020-01-07 09:11
 * version 1.0
 */
public interface PizzaIngredientFactory {
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
}
