package com.test.effectivejava;

import java.util.Collection;
import java.util.Set;

/**
 * @Auther: linklmm
 * @Date: 2019/4/8 09:58
 * @Description 复合，使用复合/转发的方法来代替InstrumentedHashSet类
 */
public class InstrumentedSet2<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet2(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
