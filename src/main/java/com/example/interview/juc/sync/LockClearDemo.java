package com.example.interview.juc.sync;

/**
 *
 * @author wxz
 * @date 14:33 2023/2/8
 */
public class LockClearDemo {

    static Object objectLock = new Object();

    public void m1() {
        synchronized (objectLock) {
            System.out.println("哈哈哈哈");
        }
    }

    public static void main(String[] args) {

        LockClearDemo lockClearDemo = new LockClearDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lockClearDemo.m1();
            }, String.valueOf(i)).start();
        }
    }
}
