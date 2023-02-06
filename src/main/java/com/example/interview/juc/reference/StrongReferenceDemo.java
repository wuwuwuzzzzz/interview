package com.example.interview.juc.reference;

class MyObject {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("invoke finalize method !!!");
    }
}

/**
 *
 * @author wxz
 * @date 10:48 2023/2/6
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {

        MyObject object = new MyObject();

        System.out.println("gc before:" + object);

        object = null;

        System.gc();

        System.out.println("gc after:" + object);
    }
}
