package com.example.interview.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author wxz
 * @date 23:55 2023/1/30
 */
public class AbaDemo {

    static AtomicInteger counter = new AtomicInteger(100);

    public static void main(String[] args) {

        new Thread(() -> {
            counter.compareAndSet(100, 101);
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(counter.compareAndSet(100, 2023) + "\t" + counter.get());
        }, "t2").start();
    }
}
