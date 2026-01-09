package com.kode.core;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CNGEngine implements Engine{

    public void start(){
        System.out.println("start cng engine");
    }

    @PostConstruct
    public void init(){
        System.out.println("post construct cngEngine");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("pre destroy cngEngine");
    }
}
