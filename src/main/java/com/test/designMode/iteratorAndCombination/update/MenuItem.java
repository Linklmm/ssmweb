package com.test.designMode.iteratorAndCombination.update;


/**
 * Description 菜单项
 *
 * @author playboy
 * @date 2020-03-15 09:47
 * version 1.0
 */
public class MenuItem extends MenuComponent {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public void print() {
        System.out.print(" " + getName());
        if (isVegetarian()) {
            System.out.print("(V)");
        }
        System.out.print(" " + getPrice());
        System.out.println("   --" + getDescription());
    }

}
