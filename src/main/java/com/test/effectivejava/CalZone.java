package com.test.effectivejava;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-18 10:11
 * @Version 1.0
 * @Description pizza的子类
 */
public class CalZone extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        CalZone build() {
            return new CalZone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private CalZone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public static void main(String[] args) {
        NyPizza pizza = (NyPizza) new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Topping.SAUSAGE).addTopping(Topping.ONION).build();
        CalZone calZone = new Builder().addTopping(Topping.HAM).sauceInside().build();
        System.out.println(pizza);
        System.out.println(calZone);
        Integer max = Integer.MAX_VALUE;
        System.out.println(max);
    }
}
