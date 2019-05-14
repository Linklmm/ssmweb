package com.test.effectivejava.six;

/**
 * @Auther: linklmm
 * @Date: 2019/5/13 15:53* @Description 第34条中的Operation类型的扩展
 */
public enum BasicOperatiion implements OperationExtra {
    PLUS("+"){
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
    },
    MINUS("-"){
        @Override
        public double apply(double x, double y) {
            return x-y;
        }
    },
    TIMES("*"){
        @Override
        public double apply(double x, double y) {
            return x*y;
        }
    },
    DIVIDE("/"){
        @Override
        public double apply(double x, double y) {
            return x/y;
        }
    };
    private final String symbol;

    BasicOperatiion(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
