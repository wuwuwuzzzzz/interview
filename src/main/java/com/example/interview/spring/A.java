package com.example.interview.spring;

/**
 *
 * @author wxz
 * @date 15:13 2022/12/7
 */
public class A {

    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public A() {
        System.out.println("--- A create success");
    }
}
