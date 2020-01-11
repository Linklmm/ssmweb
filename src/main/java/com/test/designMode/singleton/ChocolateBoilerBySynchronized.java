package com.test.designMode.singleton;


/**
 * Description 单例模式的巧克力锅炉
 * @author playboy
 * @date 2020-01-10 14:21
 * version 1.0
 * 通过synchronized保证多线程情况下单例
 * 会有性能上的问题
 */
public class ChocolateBoilerBySynchronized {
	private boolean empty;
	private boolean boiled;
	private static ChocolateBoilerBySynchronized uniqueInstance;
	public static synchronized ChocolateBoilerBySynchronized getInstance(){
		if (uniqueInstance == null){
			uniqueInstance = new ChocolateBoilerBySynchronized();
		}
		return uniqueInstance;
	}
	private ChocolateBoilerBySynchronized() {
		this.empty = true;
		this.boiled = false;
	}

	public void fill(){
		if (isEmpty()){
			empty = false;
			boiled = false;
			//在锅炉内填满巧克力和牛奶的混合物
		}
	}

	public void drain(){
		if (!isEmpty()&&isBoiled()){
			//排出煮沸的巧克力和牛奶
			empty = true;
		}
	}

	public void boil(){
		if (!isEmpty()&&!isBoiled()){
			//将炉内物煮沸
			boiled = true;
		}
	}

	public boolean isEmpty(){
		return empty;
	}
	public boolean isBoiled(){
		return boiled;
	}
}
