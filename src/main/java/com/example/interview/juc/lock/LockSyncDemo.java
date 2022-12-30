package com.example.interview.juc.lock;

/**
 *
 * @author wxz
 * @date 11:28 2022/12/30
 */
public class LockSyncDemo {

    Object object = new Object();

    public void m1() {
        synchronized (object) {
            System.out.println("hello synchronized code block");
        }
    }

    public synchronized void m2() {
        System.out.println("hello synchronized code block");
    }

    public static synchronized void m3() {
        System.out.println("hello synchronized code block");
    }

    public static void main(String[] args) {
    }
}
