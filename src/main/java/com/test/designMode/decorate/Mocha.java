package com.test.designMode.decorate;


/**
 * Description 摩卡装饰者 调料
 *
 * @author playboy
 * @date 2019-12-17 17:13
 * version 1.0
 */
public class Mocha extends CondimentDecorator {
    /**
     * 被装饰者
     */
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }

}
