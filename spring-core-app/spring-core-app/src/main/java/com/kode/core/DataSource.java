package com.kode.core;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataSource {

    public void DataSource(String userName, String pwd){
        System.out.println(userName + " "+ pwd);
    }
    @PostConstruct
    public void init(){
        System.out.println("DataSource obj created");
    }
}
