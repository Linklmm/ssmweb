package com.test.effectivejava.eight;

import java.math.BigDecimal;

/**
 * @Auther: linklmm
 * @Date: 2019/6/18 08:56
 * @Description 如果需要精确的答案，请避免使用float和double
 */
public class Sixteen {
    public static void main(String[] args) {
        System.out.println(1.03 - 0.42);
        System.out.println(1.00 - 9 * 0.10);

        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds);

        final BigDecimal TEN_CENTS = new BigDecimal(".10");

        int bigItemsBought = 0;
        BigDecimal bigFunds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS;
             bigFunds.compareTo(price) >= 0;
             price = price.add(TEN_CENTS)) {
            bigFunds = bigFunds.subtract(price);
            bigItemsBought++;
        }
        System.out.println(bigItemsBought + " items bought.");
        System.out.println("Change: $" + bigFunds);
        Integer i = new Integer(1);
        Integer i2 = new Integer(1);
        Integer i3 = null;
        Integer i4 = 1;
        Integer i5 = 1;
        System.out.println(i == i2);
        System.out.println(i.equals(i2));
        System.out.println(i3);
        System.out.println(i4 == i5);
        System.out.println(i4.equals(i5));
    }
}
