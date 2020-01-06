package com.test.designMode.decorate;


/**
 * Description 另一种饮料
 * @author playboy
 * @date 2019-12-17 17:10
 * version 1.0
 */
public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee";
	}

	@Override
	public double cost() {
		return 0.89;
	}

}
