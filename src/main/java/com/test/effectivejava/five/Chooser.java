package com.test.effectivejava.five;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Auther: linklmm
 * @Date: 2019/4/19 17:43
 * @Description 使用泛型的简单实现
 * 通过构造器编写一个带有集合的Chooser类和一个方法，并用该方法返回在集合中随机选择的一个元素
 */
public class Chooser<T> {
    private final Object[] choiceArray;

    public Chooser(Collection choices) {
        choiceArray = choices.toArray();
    }

    public Object choose() {
        Random rand = ThreadLocalRandom.current();
        return choiceArray[rand.nextInt(choiceArray.length)];
    }
}
