package com.kode.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
       /* CarWithfieldInjection car = context.getBean(CarWithfieldInjection.class);
        car.drive();*/
        /*Car car = context.getBean(Car.class);
        car.drive();*/
        //DataSource dataSource = context.getBean()
        context.close();
    }
}
