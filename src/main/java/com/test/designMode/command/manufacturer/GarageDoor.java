package com.test.designMode.command.manufacturer;


/**
 * Description
 *
 * @author playboy
 * @date 2020-01-11 14:22
 * version 1.0
 */
public class GarageDoor {
    private Light light;
    private String position;

    public GarageDoor(String position) {
        this.position = position;
    }

    public GarageDoor() {
        this.light = new Light("GarageDoor");
    }

    public void up() {
        System.out.println("GarageDoor is up !");
    }

    public void down() {
        System.out.println(GarageDoor.class.getSimpleName() + "is down !");
    }

    public void stop() {
        System.out.println(GarageDoor.class.getName() + "is stop !");
    }

    public void lightOn() {
        light.on();
    }

    public void lightOff() {
        light.off();
    }

}
