package com.example.interview.juc.interrupt;

/**
 *
 * @author wxz
 * @date 15:46 2023/1/2
 */
public class Interrupt4Demo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
        System.out.println("----------- 1");
        Thread.currentThread().interrupt();
        System.out.println("----------- 2");
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());

    }
}
