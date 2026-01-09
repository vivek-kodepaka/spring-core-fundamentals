package com.kode.core;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class DieselEngine implements Engine{

    public void start(){
        System.out.println("start diesel engine");
    }

    @PostConstruct
    public void init(){
        System.out.println("post construct dieselEngine");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("pre destroy dieselEngine");
    }
}
