package com.example.interview.juc.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 *
 * @author wxz
 * @date 13:51 2023/1/31
 */
public class AtomicMarkAbleReferenceDemo {

    static AtomicMarkableReference markableReference = new AtomicMarkableReference(100, false);

    public static void main(String[] args) {

        new Thread(() -> {

        }, "t1").start();
    }
}
