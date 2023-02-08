package com.example.interview.juc.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author wxz
 * @date 15:17 2023/2/8
 */
public class AqsDemo {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        lock.lock();
        try {

        } finally {
          lock.unlock();
        }

    }
}
