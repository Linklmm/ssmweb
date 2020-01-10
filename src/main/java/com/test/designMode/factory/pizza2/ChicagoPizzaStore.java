package com.test.designMode.factory.pizza2;


import com.test.designMode.factory.Pizza.Pizza;

/**
 * Description 芝加哥披萨店
 * @author playboy
 * @date 2020-01-06 15:33
 * version 1.0
 */
public class ChicagoPizzaStore extends PizzaStore {
	@Override
	public Pizza createPizza(String type) {
		if (type.equals("cheese")){
			return new  ChicagoStyleCheesePizza();
		}else {
			return null;
		}
	}

}
