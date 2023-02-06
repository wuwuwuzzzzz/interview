package com.example.interview.juc.reference;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author wxz
 * @date 11:00 2023/2/6
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {

        SoftReference<MyObject> softReference = new SoftReference<>(new MyObject());
        System.out.println(softReference.get());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(softReference.get());

        try {
            Byte[] bytes = new Byte[20 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(softReference.get());
        }
    }
}
