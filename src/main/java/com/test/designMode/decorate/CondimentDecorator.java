package com.test.designMode.decorate;


/**
 * Description 调料装饰者 抽象装饰者
 *
 * @author playboy
 * @date 2019-12-17 17:03
 * version 1.0
 */
public abstract class CondimentDecorator extends Beverage {
    @Override
    public abstract String getDescription();

    @Override
    public double cost() {
        return 0;
    }

}
