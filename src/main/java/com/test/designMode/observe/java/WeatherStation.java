package com.test.designMode.observe.java;


/**
 * Description: 气象站
 *
 * @author: playboy
 * @date: 2019-12-09 09:01
 * version: 1.0
 */
public class WeatherStation {
    public static void main(String[] args) {
        //主题
        WeatherData weatherData = new WeatherData();

        //观察者
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
