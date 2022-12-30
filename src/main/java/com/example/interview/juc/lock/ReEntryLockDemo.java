package com.example.interview.juc.lock;

/**
 *
 * @author wxz
 * @date 16:25 2022/12/30
 */
public class ReEntryLockDemo {

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "\t come in");
        m2();
        System.out.println(Thread.currentThread().getName() + "\t end");
    }

    public synchronized void m2() {
        System.out.println(Thread.currentThread().getName() + "\t come in");
        m3();
        System.out.println(Thread.currentThread().getName() + "\t end");
    }

    public synchronized void m3() {
        System.out.println(Thread.currentThread().getName() + "\t come in");
    }

    public static void main(String[] args) {

        ReEntryLockDemo reEntryLockDemo = new ReEntryLockDemo();

        new Thread(() -> {
            reEntryLockDemo.m1();
        }, "t1").start();
    }

    private static void M1() {
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
