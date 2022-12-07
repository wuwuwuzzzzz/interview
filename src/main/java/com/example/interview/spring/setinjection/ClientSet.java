package com.example.interview.spring.setinjection;

/**
 *
 * @author wxz
 * @date 14:55 2022/12/7
 */
public class ClientSet {
    public static void main(String[] args) {
        ServiceC serviceC = new ServiceC();
        ServiceD serviceD = new ServiceD();
        serviceC.setServiceD(serviceD);
        serviceD.setServiceC(serviceC);
    }
}
