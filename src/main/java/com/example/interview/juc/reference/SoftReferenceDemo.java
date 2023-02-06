package com.example.interview.juc.reference;

import java.lang.ref.SoftReference;

/**
 *
 * @author wxz
 * @date 11:00 2023/2/6
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {

        SoftReference<MyObject> softReference = new SoftReference<>(new MyObject());
        System.out.println(softReference.get());
    }
}
