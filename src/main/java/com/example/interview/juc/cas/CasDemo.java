package com.example.interview.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author wxz
 * @date 14:29 2023/1/29
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(5);
        System.out.println(count.compareAndSet(5, 2023) + "\t" + count.get());
        System.out.println(count.compareAndSet(6, 2023) + "\t" + count.get());
        count.getAndIncrement();
    }
}
