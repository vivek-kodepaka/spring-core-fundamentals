package com.kode.core;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CarWithfieldInjection {
    private Engine engine;

    public void drive(){
        engine.start();
    }

    @PostConstruct
    public void init(){
        System.out.println("post construct CarWithfieldInjection ");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("pre destroy CarWithfieldInjection ");
    }
}
