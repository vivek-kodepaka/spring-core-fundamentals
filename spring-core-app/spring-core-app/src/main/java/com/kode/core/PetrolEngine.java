package com.kode.core;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//@Component
public class PetrolEngine implements Engine{

    public void start(){
        System.out.println("start petrol engine");
    }

    @PostConstruct
    public void init(){
        System.out.println("post construct petrolEngine");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("pre destroy petrolEngine");
    }
}
