package com.example.interview.juc.atomic;

import java.util.concurrent.TimeUnit;
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

        MyNumber myNumber = new MyNumber();

        for (int i = 1; i <= 50; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myNumber.addPlus();
                }
            }, String.valueOf(i)).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + "\t" + myNumber.counter.get());
    }
}
