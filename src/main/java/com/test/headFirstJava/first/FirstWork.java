package com.test.headFirstJava.first;


/**
 * Description 第一章练习题
 * @author playboy
 * @date 2020-03-12 21:08
 * version 1.0
 */
public class FirstWork {
	public static void main(String[] args) {
		FirstWork firstWork = new FirstWork();
		firstWork.my();
		System.out.println();
		firstWork.book();
	}

	private void my() {
		int x = 0;
		while (x < 4) {
			System.out.print("a");
			if (x < 1) {
				System.out.print(" ");
			}
			System.out.print("noise");
			if (x < 1) {
				x = x + 1;
				System.out.print("annoys");

			}
			if (x == 1) {
				System.out.print("an");
			}
			if (x > 1) {
				System.out.print(" oyster");
			}
			System.out.print("");
			x = x + 2;
		}
	}

	private void book() {
		int x = 0;
		while (x < 4) {
			System.out.print("a");
			if (x < 1) {
				System.out.print(" ");
			}
			System.out.print("n");
			if (x > 1) {

				System.out.print(" oyster");
				x = x + 2;

			}
			if (x == 1) {
				System.out.print("noys");
			}
			if (x < 1) {
				System.out.print("oise");
			}
			System.out.print("");
			x = x + 1;
		}
	}

}
