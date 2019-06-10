package com.test.effectivejava.eight;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: linklmm
 * @Date: 2019/6/10 08:31* @Description 重写
 */
class Wine{
    String name(){
        return "wine";
    }
}
class SparklingWine extends Wine{
    @Override
    String name() {
        return "sparkling wine";
    }
}
class Champagne extends SparklingWine{
    @Override
    String name() {
        return "champagne";
    }
}
public class Overriding {
    public static void main(String[] args) {
        List<Wine> wineList = new ArrayList<>();
        wineList.add(new Wine());
        wineList.add(new SparklingWine());
        wineList.add(new Champagne());
        for (Wine wine :wineList){
            System.out.println(wine.name());
        }

    }
}
