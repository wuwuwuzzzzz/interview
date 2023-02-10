package com.example.interview.juc.sync;

/**
 *
 * @author wxz
 * @date 14:33 2023/2/8
 */
public class LockClearDemo {

    static Object objectLock = new Object();

    public void m1() {
//        synchronized (objectLock) {
//            System.out.println("哈哈哈哈");
//        }
        // 锁消除问题 JIT编译器会无视它
        Object o = new Object();
        synchronized (o) {
            System.out.println("哈哈哈" + "\t" + o.hashCode() + "\t" + objectLock.hashCode());
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
