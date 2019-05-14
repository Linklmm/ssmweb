package com.test.effectivejava.six;


/**
 * @Auther: linklmm
 * @Date: 2019/5/9 11:24* @Description 用EnumMap代替序数索引
 */
public class Plant {
    enum LifeCycle{ ANNUAL,PERENNIAL,BIENNIAL}
    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifecycle){
        this.name = name;
        this.lifeCycle = lifecycle;
    }

    @Override
    public String toString() {
        return name;
    }
}
