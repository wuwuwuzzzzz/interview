package com.example.interview.juc.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @author wxz
 * @date 18:18 2023/2/11
 */
public class StampedLockDemo {

    static int number = 37;

    static StampedLock stampedLock = new StampedLock();

    public void write() {

        long stamp = stampedLock.writeLock();

        System.out.println("写线程准备修改");

        try {
            number = number + 13;
        } finally {
            stampedLock.unlockWrite(stamp);
        }

        System.out.println("写线程修改结束");
    }

    /**
     * 悲观读，读没有完成的时候写锁无法获得锁
     *
     * @author wxz
     * @date 18:32 2023/2/11
     */
    public void read() {

        long stamp = stampedLock.readLock();

        System.out.println("come in");

        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("正在读取中...");
        }

        try {
            int result = number;
            System.out.println(result);
        } finally {
            stampedLock.unlockRead(stamp);
        }

    }

    /**
     * 乐观读，读的过程也允许获取写锁介入
     *
     * @author wxz
     * @date 18:33 2023/2/11
     */
    public void tryOptimisticRead() {

        long stamp = stampedLock.tryOptimisticRead();

        int result = number;

        // 故意间隔4秒，很乐观地认为读m没有其他线程修改过number值，具体靠判断
        System.out.println(
            "4秒前stampedLock.validate方法值(true无修改，false有修改)" + "\t" + stampedLock.validate(stamp));

        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread()
                .getName() + "\t" + "正在读取" + i + "秒后stampedLock.validate方法值(true无修改，false有修改)" + stampedLock.validate(stamp));
        }

        if (!stampedLock.validate(stamp)) {
            System.out.println("有人修改过====有写操作");
            stamp = stampedLock.readLock();
            try {
                System.out.println("从乐观读升级为悲观读");
                result = number;
                System.out.println("重新悲观读后result: " + result);
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }



    }

    public static void main(String[] args) {

        StampedLockDemo stampedLockDemo = new StampedLockDemo();
//
//        new Thread(() -> {
//            stampedLockDemo.read();
//        }, "readThread").start();
//
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        new Thread(() -> {
//            stampedLockDemo.write();
//        }, "writeThread").start();
//
//        try {
//            TimeUnit.SECONDS.sleep(4);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(number);

        new Thread(() -> {
            stampedLockDemo.tryOptimisticRead();
        }, "readThread").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "come in");
            stampedLockDemo.write();
        }, "writeThread").start();
    }
}
