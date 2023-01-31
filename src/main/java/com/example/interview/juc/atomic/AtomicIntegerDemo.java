package com.example.interview.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

class MyNumber{

    AtomicInteger counter = new AtomicInteger();

    public void addPlus() {
        counter.getAndIncrement();
    }
}

/**
 *
 * @author wxz
 * @date 10:32 2023/1/31
 */
public class AtomicIntegerDemo {

    public static final int SIZE = 50;

    public static void main(String[] args) {

    }
}
