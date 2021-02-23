package com.test.designMode.templateMethod;


import lombok.Data;

/**
 * Description 鸭子类
 *
 * @author playboy
 * @date 2020-03-03 18:05
 * version 1.0
 */
@Data
public class Duck implements Comparable {
    private String name;
    private int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Duck otherDuck = (Duck) o;
        if (this.weight < otherDuck.weight) {
            return -1;
        } else if (this.weight == otherDuck.weight) {
            return 0;
        } else {
            return 1;
        }
    }

}
