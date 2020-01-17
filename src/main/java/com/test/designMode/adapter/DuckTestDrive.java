package com.test.designMode.adapter;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import org.junit.jupiter.api.Test;

/**
 * Description 测试适配器
 * @author playboy
 * @date 2020-01-15 15:22
 * version 1.0
 */
public class DuckTestDrive {
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();

		WildTurkey turkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);

		System.out.println("the turkey says ...");
		turkey.gobble();
		turkey.fly();

		System.out.println("\nThe Duck says ...");
		testDuck(duck);

		System.out.println("\nThe TurkeyAdapter says...");
		testDuck(turkeyAdapter);
	}

	private static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}

	@Test
	public void testDouble(){
		double d = 7.145;
		//DecimalFormat df = new DecimalFormat("#.00");
		//String str = df.format(d);
		//System.out.println(str);
		System.out.println(getPriceNum(d));
	}

	/**
	 * 数字为整数,去掉小数点之后的部分
	 */
	public static String getPriceNum(Double arg) {
		if (!numberIsNullOrZero(arg)) {
			double temp = BigDecimal.valueOf(arg).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			if (temp % 1.0 == 0) {
				return String.valueOf(Math.round(temp));
			} else {
				return String.valueOf(temp);
			}
		}
		return "0";
	}

	private static boolean numberIsNullOrZero(Number num) {
		return null == num || num.doubleValue() == 0;
	}

}
