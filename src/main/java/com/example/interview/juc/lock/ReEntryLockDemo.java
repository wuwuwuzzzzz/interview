package com.example.interview.juc.lock;

/**
 *
 * @author wxz
 * @date 16:25 2022/12/30
 */
public class ReEntryLockDemo {
    public static void main(String[] args) {

        final Object object = new Object();

        new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "\t ------- 外层调用");
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + "\t ------- 中层调用");
                    synchronized (object) {
                        System.out.println(Thread.currentThread().getName() + "\t ------- 内层调用");
                    }
                }
            }
        }, "t1").start();
    }
}
