package com.test.designMode.observe;


/**
 * @description: 观察者
 * @author: playboy
 * @date: 2019-12-02 20:19
 * @version: 1.0
 */
public interface Observer {
	public void update(float temp, float humidity, float pressure);

}
