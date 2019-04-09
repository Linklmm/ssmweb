package com.test.effectivejava;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: linklmm
 * @Date: 2019/4/8 09:44
 * @Description 复合优先于继承
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet(){
    }

    public InstrumentedHashSet(int initCap ,float loadFactor){
        super(initCap,loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount+=c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        //通过addAll方法增加的每个元素都被计算了两次
        s.addAll(Arrays.asList("snap","crackle","pop"));
        System.out.println(s.getAddCount());

        InstrumentedSet2<String> s2 = new InstrumentedSet2<>(s);
        //通过addAll方法增加的每个元素都被计算了两次
        s2.addAll(Arrays.asList("snap2","crackle2","pop2"));
        System.out.println(s2.getAddCount());
        System.out.println(s2.toString());
    }
}
