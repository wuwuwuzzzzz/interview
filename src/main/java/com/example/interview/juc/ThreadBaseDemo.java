package com.example.interview.juc;

/**
 *
 * @author wxz
 * @date 13:51 2022/12/26
 */
public class ThreadBaseDemo {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

        }, "t1");

        t1.start();
    }
}
