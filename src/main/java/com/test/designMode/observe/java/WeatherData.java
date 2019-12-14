package com.test.designMode.observe.java;


import java.util.Observable;

/**
 * @description: 可观察者=主题，Java内置的观察者模式
 * @author: playboy
 * @date: 2019-12-06 17:11
 * @version: 1.0
 */
public class WeatherData extends Observable {
	private float temperature;
	private float humidity;
	private float pressure;
	public void setMeasurements(float temperature,float humidity,float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		//通知观察者
		mesurementsChanged();
	}

	public void mesurementsChanged() {
		setChanged();
		notifyObservers();
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

}
