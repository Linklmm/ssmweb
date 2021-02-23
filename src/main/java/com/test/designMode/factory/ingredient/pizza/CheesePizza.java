package com.test.designMode.factory.ingredient.pizza;


import com.test.designMode.factory.ingredient.PizzaIngredientFactory;

/**
 * Description
 *
 * @author playboy
 * @date 2020-01-08 11:27
 * version 1.0
 */
public class CheesePizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }

}
