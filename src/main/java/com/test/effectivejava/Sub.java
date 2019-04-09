package com.test.effectivejava;

import java.time.Instant;

/**
 * @Auther: linklmm
 * @Date: 2019/4/9 14:49
 * @Description 构造器决不能调用可被覆盖的方法，无论是直接调用还是间接调用
 */
public final class Sub  extends Super{
    private final Instant instant;

    public Sub(){
        instant = Instant.now();
    }

    public Sub(Instant instant) {
        this.instant = instant;
    }

    @Override
    public void overrideMe() {
        //调用instant域的任何方法将报空指针异常
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
