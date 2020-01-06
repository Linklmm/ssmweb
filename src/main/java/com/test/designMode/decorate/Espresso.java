package com.test.designMode.decorate;


/**
 * Description 浓缩咖啡 饮料
 * @author playboy
 * @date 2019-12-17 17:08
 * version 1.0
 */
public class Espresso extends Beverage{
	public Espresso() {
		description = "Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
	}

}
