package com.test.designMode.command.manufacturer;


/**
 * Description 厂商类 点灯类
 *
 * @author playboy
 * @date 2020-01-11 14:10
 * version 1.0
 */
public class Light {
    /**
     * 位置
     */
    private String position;

    public void on() {
        System.out.println(position + " Light is on!");
    }

    public void off() {
        System.out.println(position + " light is off!");
    }

    public Light(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Light{" +
                "position='" + position + '\'' +
                '}';
    }

}
