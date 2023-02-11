package com.example.interview.juc.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author wxz
 * @date 16:24 2023/2/11
 */
public class LockDownGradingDemo {
    public static void main(String[] args) {

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

//        writeLock.lock();
//        System.out.println("写入");
//        writeLock.unlock();
//
//        readLock.lock();
//        System.out.println("读取");
//        readLock.unlock();

        writeLock.lock();
        System.out.println("写入");

        readLock.lock();
        System.out.println("读取");
        writeLock.unlock();
        readLock.unlock();
    }
}
