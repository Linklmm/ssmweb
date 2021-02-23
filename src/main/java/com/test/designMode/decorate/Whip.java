package com.test.designMode.decorate;


/**
 * Description 奶泡装饰者 调料
 *
 * @author playboy
 * @date 2019-12-25 09:33
 * version 1.0
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .30 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Whip";
    }

}
