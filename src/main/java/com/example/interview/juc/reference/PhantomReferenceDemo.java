package com.example.interview.juc.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 *
 * @author wxz
 * @date 11:33 2023/2/6
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) {

        MyObject myObject = new MyObject();

        ReferenceQueue<MyObject> queue = new ReferenceQueue<MyObject>();

        PhantomReference<MyObject> phantomReference = new PhantomReference<>(myObject, queue);

        System.out.println(phantomReference.get());
    }
}
