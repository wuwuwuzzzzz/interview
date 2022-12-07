package com.example.interview.spring.circulardepend;

import com.example.interview.spring.circulardepend.A;

/**
 *
 * @author wxz
 * @date 15:13 2022/12/7
 */
public class B {

    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B() {
        System.out.println("--- B create success");
    }
}
