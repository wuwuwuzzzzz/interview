package com.example.interview.juc.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 *
 * @author wxz
 * @date 11:30 2023/1/31
 */
public class AtomicIntegerArrayDemo {
    public static void main(String[] args) {

        AtomicIntegerArray array = new AtomicIntegerArray(5);

        for (int i = 0; i < array.length(); i++) {
            System.out.println(array.get(i));
        }
    }
}
