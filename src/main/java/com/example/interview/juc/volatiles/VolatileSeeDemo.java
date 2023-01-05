package com.example.interview.juc.volatiles;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author wxz
 * @date 14:24 2023/1/5
 */
public class VolatileSeeDemo {

    static boolean flag = true;

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t  -------- come in");
            while (flag) {

            }
            System.out.println(Thread.currentThread().getName() + "\t  -------- 程序停止 ");
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        flag = false;

        System.out.println(Thread.currentThread().getName() + "\t  -------- 修改完成");
    }
}
