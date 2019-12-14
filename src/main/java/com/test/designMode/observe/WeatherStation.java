package com.test.designMode.observe;


/**
 * @description: 气象站
 * @author: playboy
 * @date: 2019-12-05 09:31
 * @version: 1.0
 */
public class WeatherStation {
	public static void main(String[] args) {
		//主题
		WeatherData weatherData = new WeatherData();

		//观察者
		CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
		StaticsDisplay staticsDisplay = new StaticsDisplay(weatherData);
		weatherData.setMeasurementsChanged(80,65,30.4f);
		weatherData.setMeasurementsChanged(82,70,29.2f);
		weatherData.setMeasurementsChanged(78,90,29.2f);
	}
}
