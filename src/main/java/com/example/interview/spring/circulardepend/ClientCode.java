package com.example.interview.spring.circulardepend;

import com.example.interview.spring.circulardepend.A;
import com.example.interview.spring.circulardepend.B;

/**
 *
 * @author wxz
 * @date 15:13 2022/12/7
 */
public class ClientCode {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.setB(b);
        b.setA(a);
    }
}
