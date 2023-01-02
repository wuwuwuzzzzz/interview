package com.example.interview.juc.interrupt;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author wxz
 * @date 15:32 2023/1/2
 */
public class Interrupt3Demo {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "\t 中断标识位: " + Thread.currentThread().isInterrupted() + " 程序停止");
                    break;
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }

                System.out.println("------ hello Interrupt3Demo");
            }
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread t2 = new Thread(() -> {
            t1.interrupt();
        }, "t2");
        t2.start();
    }
}
