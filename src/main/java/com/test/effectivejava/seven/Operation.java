package com.test.effectivejava.seven;

import java.util.function.DoubleBinaryOperator;

/**
 * @Auther: linklmm
 * @Date: 2019/5/16 08:57* @Description 使用Lambda表达式实现第六章的Operation枚举
 */
public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
