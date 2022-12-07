package com.example.interview.spring.constructorinjection;

import org.springframework.stereotype.Component;

/**
 * @author wxz
 * @date 12:03 2022/12/7
 */
@Component
public class ServiceB {

    private ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
