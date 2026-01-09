package com.kode.core;

import com.kode.core.conditinal.AzureCondition;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(AzureCondition.class)
public class DataSource {

    public  DataSource(@Value("${db.url}") String userName,@Value("${db.url}") String pwd){
        System.out.println(userName + " "+ pwd);
    }
    @PostConstruct
    public void init(){
        System.out.println("DataSource obj created");
    }
}
