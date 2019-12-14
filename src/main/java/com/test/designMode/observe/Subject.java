package com.test.designMode.observe;


/**
 * @description: 主题接口
 * @author: playboy
 * @date: 2019-12-02 20:18
 * @version: 1.0
 */
public interface Subject {
	/**
	 * 注册观察者
	 * @param o
	 */
	public void registerObserver(Observer o);

	/**
	 * 移除观察者
	 * @param o
	 * @throws Exception
	 */
	public void removeObserver(Observer o) throws Exception;

	/**
	 * 通知观察者
	 */
	public void notifyObserver();
}
