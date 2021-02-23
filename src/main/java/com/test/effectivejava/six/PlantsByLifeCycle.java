package com.test.effectivejava.six;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: linklmm
 * @Date: 2019/5/10 10:09* @Description 用EnumMap代替序数索引
 */
public class PlantsByLifeCycle {

    public static void main(String[] args) {
        Set<Plant>[] plantsByLifeCycle =
                (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }
    }
}
