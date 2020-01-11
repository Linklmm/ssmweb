package com.test.designMode.singleton;


/**
 * Description 单例模式的巧克力锅炉
 * @author playboy
 * @date 2020-01-10 14:21
 * version 1.0
 * 通过双重检查锁。保证了线程安全
 */
public class ChocolateBoilerByDoubleInsurance {
	private boolean empty;
	private boolean boiled;
	/**
	 * 	volatile 确保当uniqueInstance变量被初始化实例时，多个线程正确地处理uniqueInstance变量。
	 */
	private volatile static ChocolateBoilerByDoubleInsurance uniqueInstance;

	public static ChocolateBoilerByDoubleInsurance getInstance() {
		/**
		 * 第一次创建才彻底进行里面的代码
		 */
		if (uniqueInstance == null){
			synchronized (ChocolateBoilerByDoubleInsurance.class){
				if (uniqueInstance == null){
					uniqueInstance = new ChocolateBoilerByDoubleInsurance();
				}
			}
		}
		return uniqueInstance;
	}

	private ChocolateBoilerByDoubleInsurance() {
		this.empty = true;
		this.boiled = false;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
			//在锅炉内填满巧克力和牛奶的混合物
		}
	}

	public void drain() {
		if (!isEmpty() && isBoiled()) {
			//排出煮沸的巧克力和牛奶
			empty = true;
		}
	}

	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			//将炉内物煮沸
			boiled = true;
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

}
