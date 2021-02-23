package com.test.designMode.observe.java;


import com.test.designMode.observe.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @description: java内置的观察者模式，观察者的具体实现
 * @author: playboy
 * @date: 2019-12-06 17:14
 * @version: 1.0
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions :" + temperature + "F degrees and " + humidity + "% humidity");
    }

}
