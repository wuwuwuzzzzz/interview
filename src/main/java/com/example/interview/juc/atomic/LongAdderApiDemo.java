package com.example.interview.juc.atomic;

import java.util.concurrent.atomic.LongAdder;

/**
 *
 * @author wxz
 * @date 11:17 2023/2/1
 */
public class LongAdderApiDemo {
    public static void main(String[] args) {

        LongAdder longAdder = new LongAdder();

        longAdder.increment();
        longAdder.increment();
        longAdder.increment();

        System.out.println(longAdder.sum());
    }
}
