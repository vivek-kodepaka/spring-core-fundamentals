package com.kode.core;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Car {
    @Autowired
    private Engine CNGEngine;
    /*public Car(Engine engine){
        this.petrolEngine=engine;//constructor engine no autowired requires
    }*/



    public void drive(){
        CNGEngine.start();
    }

    @PostConstruct
    public void init(){
        System.out.println("post construct Car");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("pre destroy Car");
    }
}
