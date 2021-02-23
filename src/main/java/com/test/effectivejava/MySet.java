package com.test.effectivejava;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * @Auther: linklmm
 * @Date: 2019/4/17 09:16
 * @Description 使用非静态成员类来实现set
 */
public class MySet<E> extends AbstractSet<E> {
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    private class MyIterator implements Iterator<E> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
