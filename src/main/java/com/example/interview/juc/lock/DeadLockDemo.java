package com.example.interview.juc.lock;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author wxz
 * @date 16:50 2022/12/30
 */
public class DeadLockDemo {
    public static void main(String[] args) {

        final Object objectA = new Object();

        final Object objectB = new Object();

        new Thread(() -> {
            synchronized (objectA) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有A锁，希望获取B锁");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (objectB) {
                    System.out.println(Thread.currentThread().getName() + "\t 成功获取B锁");
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (objectB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有B锁，希望获取A锁");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (objectA) {
                    System.out.println(Thread.currentThread().getName() + "\t 成功获取A锁");
                }
            }
        }, "B").start();
    }
}
