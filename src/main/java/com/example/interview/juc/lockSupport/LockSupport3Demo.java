package com.example.interview.juc.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 *
 * @author wxz
 * @date 14:47 2023/1/3
 */
public class LockSupport3Demo {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t -------- come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t -------- 被唤醒");
        }, "t1");
        t1.start();

        new Thread(() -> {
            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName() + "\t -------- 发出通知");
        }, "t2").start();
    }
}
