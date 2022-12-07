package com.example.interview.spring.setinjection;

import org.springframework.stereotype.Component;

/**
 *
 * @author wxz
 * @date 14:50 2022/12/7
 */
@Component
public class ServiceC {

    private ServiceD serviceD;

    public ServiceD getServiceD() {
        return serviceD;
    }

    public void setServiceD(ServiceD serviceD) {
        this.serviceD = serviceD;
        System.out.println("C里面引用了D");
    }
}
