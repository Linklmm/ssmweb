package com.test.effectivejava;


import sun.misc.Cleaner;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-21 09:40
 * @Version 1.0
 * @Description 清除方法使用
 */
public class Room implements AutoCloseable {
//    private static final Cleaner cleaner = Cleaner.create(new Room(),new State());

    private static class State implements Runnable {
        int numJunkPiles;

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    private final State state;

    //    private final Cleaner.Cleanable cleanable;
    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
    }

    @Override
    public void close() throws Exception {
    }
}
