package com.test.designMode.observe.java;


import com.test.designMode.observe.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * Description:
 *
 * @author: playboy
 * @date: 2019-12-09 08:52
 * version: 1.0
 */
public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;
    Observable observable;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("lastPressure: " + lastPressure + " currentPressure:" + currentPressure);

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }

}
