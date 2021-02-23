package com.test.designMode.observe;


/**
 * @description: 布告板
 * @author: playboy
 * @date: 2019-12-05 09:18
 * @version: 1.0
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");

    }

    /**
     * @param temp     温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

}
