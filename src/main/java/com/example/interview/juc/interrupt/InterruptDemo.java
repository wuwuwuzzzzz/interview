package com.example.interview.juc.interrupt;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author wxz
 * @date 13:59 2023/1/2
 */
public class InterruptDemo {

    static volatile boolean isStop = false;

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                if (isStop) {
                    System.out.println(Thread.currentThread().getName() + "\t isStop被修改位true，程序停止");
                    break;
                }
            }
            System.out.println("hello volatile");
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            isStop = true;
        }, "t2").start();
    }
}
