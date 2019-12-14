package com.test.designMode.first;


/**
 * 父类
 * @author: playboy
 * @date: 2019-12-02 08:55
 * @version: 1.0
 */
public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBeahavior quackBeahavior;

	public Duck() {
	}

	public abstract void display();

	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBeahavior.quack();
	}

	public void swim() {
		System.out.println("All ducks float,even decoys!");
	}

}
