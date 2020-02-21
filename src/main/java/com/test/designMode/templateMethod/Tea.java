package com.test.designMode.templateMethod;


/**
 * Description 茶
 * @author playboy
 * @date 2020-01-17 11:26
 * version 1.0
 */
public class Tea {
	public Tea() {
		boilWater();
		steepTeaBag();
		pourInCup();
		addLemon();
	}

	public void boilWater() {
		System.out.println("Boiling water");
	}

	public void steepTeaBag() {
		System.out.println("Steeping the tea");
	}

	public void addLemon() {
		System.out.println("Adding Lemon");
	}

	public void pourInCup() {
		System.out.println("Pouring into cup");
	}

}
