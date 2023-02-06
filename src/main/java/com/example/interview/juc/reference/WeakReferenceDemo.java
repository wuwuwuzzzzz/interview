package com.example.interview.juc.reference;

import java.lang.ref.WeakReference;

/**
 *
 * @author wxz
 * @date 11:11 2023/2/6
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        WeakReference<MyObject> weakReference = new WeakReference<>(new MyObject());
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
    }
}
