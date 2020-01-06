package com.test.designMode.decorate;


/**
 * Description 深焙咖啡 饮料
 * @author playboy
 * @date 2019-12-25 09:19
 * version 1.0
 */
public class DarkRoast extends Beverage {
	public DarkRoast() {
		description="darkRoast Coffee";
	}

	@Override
	public double cost() {
		return 0.2;
	}

}
