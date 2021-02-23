package com.test.effectivejava.five;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Auther: linklmm
 * @Date: 2019/4/19 17:50
 * @Description 使用泛型
 */
public class Chooser2<T> {
    private final List<T> choiceList;

    public Chooser2(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random random = ThreadLocalRandom.current();
        return choiceList.get(random.nextInt(choiceList.size()));
    }
}
