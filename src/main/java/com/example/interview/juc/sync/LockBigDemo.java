package com.example.interview.juc.sync;

/**
 *
 * @author wxz
 * @date 14:40 2023/2/8
 */
public class LockBigDemo {

    static Object objectLock = new Object();
    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (objectLock) {
                System.out.println("111");
            }
            synchronized (objectLock) {
                System.out.println("222");
            }
            synchronized (objectLock) {
                System.out.println("333");
            }
            synchronized (objectLock) {
                System.out.println("444");
            }
        }, "t1").start();

    }
}
