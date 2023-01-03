package com.example.interview.juc.lockSupport;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author wxz
 * @date 14:18 2023/1/3
 */
public class LockSupportDemo {
    public static void main(String[] args) {

        Object o = new Object();

        new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + "\t ------- come in");
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "\t ------- 被唤醒");
            }
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            synchronized (o) {
                o.notify();
                System.out.println(Thread.currentThread().getName() + "\t ------- 发出通知");
            }
        }, "t2").start();
    }
}
