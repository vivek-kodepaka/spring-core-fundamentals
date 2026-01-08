package com.kode.core;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements Engine{
    public void start(){
        System.out.println("start petrol engine");
    }
}
