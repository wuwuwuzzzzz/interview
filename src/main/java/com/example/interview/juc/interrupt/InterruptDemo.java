package com.example.interview.juc.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author wxz
 * @date 13:59 2023/1/2
 */
public class InterruptDemo {

    static volatile boolean isStop = false;

    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "\t isInterrupted被修改位true，程序停止");
                    break;
                }
                System.out.println("hello interrupted");
            }
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            t1.interrupt();
        }, "t2").start();
    }

    /**
     * atomicBoolean打断线程
     *
     * @author wxz
     * @date 14:53 2023/1/2
     */
    private static void m2() {
        new Thread(() -> {
            while (true) {
                if (atomicBoolean.get()) {
                    System.out.println(Thread.currentThread().getName() + "\t atomicBoolean被修改位true，程序停止");
                    break;
                }
                System.out.println("hello atomicBoolean");
            }
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            atomicBoolean.set(true);
        }, "t2").start();
    }

    /**
     * volatile停止线程
     *
     * @author wxz
     * @date 14:52 2023/1/2
     */
    private static void m1() {
        new Thread(() -> {
            while (true) {
                if (isStop) {
                    System.out.println(Thread.currentThread().getName() + "\t isStop被修改位true，程序停止");
                    break;
                }
                System.out.println("hello volatile");
            }
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            isStop = true;
        }, "t2").start();
    }
}
