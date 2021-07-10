package com.test.algorithm.book.dataStructure;

import java.util.Iterator;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-06-30 20:02
 * @description: 先进先出队列的实现
 **/
public class Queue<Item> implements Iterable<Item> {
    /**
     * 指向最早添加的节点的链接
     */
    private Node<Item> first;
    /***
     * 指向最近添加的节点的链接
     */
    private Node<Item> last;
    /**
     * 元素的数量
     */
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return this.size;
    }

    /**
     * 向表位添加元素
     * @param item
     */
    public void enqueue(Item item){
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    /**
     * 向表头删除元素
     * @return
     */
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        size--;
        return item;

    }

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
