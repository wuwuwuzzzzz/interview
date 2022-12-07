package com.example.interview.spring.setinjection;

import com.example.interview.spring.constructorinjection.ServiceA;
import org.springframework.stereotype.Component;

/**
 *
 * @author wxz
 * @date 14:51 2022/12/7
 */
@Component
public class ServiceD {

    private ServiceC serviceC;

    public ServiceC getServiceC() {
        return serviceC;
    }

    public void setServiceC(ServiceC serviceC) {
        this.serviceC = serviceC;
        System.out.println("D里面引用了C");
    }
}
