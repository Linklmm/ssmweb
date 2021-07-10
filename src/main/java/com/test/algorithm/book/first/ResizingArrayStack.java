package com.test.algorithm.book.first;

import java.util.Iterator;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-06-15 21:39
 * @description: 能够动态调整数组大小的实现
 **/
public class ResizingArrayStack<T> implements Iterable<T> {
    private T[] a = (T[]) new Object[1];

    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(T item) {
        if (N == a.length) {
            resize(N * 2);
        }
        a[N++] = item;
    }

    public T pop() {
        T item = a[N];
        a[N] = null;
        N--;
        //始终保持至少有1/2的元素被使用
        if (N > 0 && N < a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }
    }
}
