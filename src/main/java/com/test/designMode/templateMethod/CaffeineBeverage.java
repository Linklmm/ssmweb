package com.test.designMode.templateMethod;


/**
 * Description 咖啡因饮料抽象类
 * @author playboy
 * @date 2020-03-02 17:06
 * version 1.0
 */
public abstract class CaffeineBeverage {
	final void prepareRecipe(){
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}
	abstract void brew();
	abstract void addCondiments();
	void boilWater(){
		System.out.println("Boiling water");
	}
	void pourInCup(){
		System.out.println("Pouring into cup");
	}
}
