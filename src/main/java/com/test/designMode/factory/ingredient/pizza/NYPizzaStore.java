package com.test.designMode.factory.ingredient.pizza;


import com.test.designMode.factory.ingredient.NYPizzaIngredientFactory;
import com.test.designMode.factory.ingredient.PizzaIngredientFactory;

/**
 * Description
 *
 * @author playboy
 * @date 2020-01-08 11:34
 * version 1.0
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        com.test.designMode.factory.ingredient.pizza.Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York style cheese pizza");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York style cheese pizza");
        }
        return pizza;
    }

}
