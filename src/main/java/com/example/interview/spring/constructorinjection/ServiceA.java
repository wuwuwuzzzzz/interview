package com.example.interview.spring.constructorinjection;

import org.springframework.stereotype.Component;

/**
 *
 * @author wxz
 * @date 12:04 2022/12/7
 */
@Component
public class ServiceA {

    public ServiceB serviceB;

    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
}
