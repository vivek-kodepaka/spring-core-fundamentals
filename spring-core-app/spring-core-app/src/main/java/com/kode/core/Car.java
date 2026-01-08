package com.kode.core;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private Engine engine;
    public Car(Engine engine){
        this.engine=engine;//constructor engine no autowired requires
    }

    public void drive(){
        engine.start();
    }
}
