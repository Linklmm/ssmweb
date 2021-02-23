package com.test.designMode.observe;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

/**
 * @description: 此布告板跟踪最小、平均、最大的观测值
 * @author: playboy
 * @date: 2019-12-06 10:45
 * @version: 1.0
 */
public class StaticsDisplay implements Observer, DisplayElement {
    private ArrayList<Float> temps = new ArrayList<>();
    private float sum;

    private Subject weatherData;

    public StaticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    /**
     * 得到最大值
     *
     * @param temps
     * @return
     */
    private float getMax(ArrayList<Float> temps) {
        Optional<Float> max = temps.stream().max(Comparator.comparingDouble(Float::floatValue));
        return max.get();
    }

    private float getMin(ArrayList<Float> temps) {
        Optional<Float> min = temps.stream().min(Float::compareTo);
        return min.get();
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + sum / (float) temps.size() + "/" + getMax(temps) + "/" + getMin(temps));
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        temps.add(temp);
        sum += temp;
        display();
    }

}
