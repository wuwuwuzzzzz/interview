package com.example.interview.juc.atomic;

import java.util.concurrent.CountDownLatch;
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
        CountDownLatch countDownLatch = new CountDownLatch(SIZE);

        for (int i = 1; i <= 50; i++) {
            new Thread(() -> {
                try {
                    for (int j = 1; j <= 1000; j++) {
                        myNumber.addPlus();
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }, String.valueOf(i)).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + "\t" + myNumber.counter.get());
    }
}
