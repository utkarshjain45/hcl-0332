package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee e1 = ctx.getBean(Employee.class);
        e1.display();
        System.out.println(e1.hashCode());

        Employee e2 = ctx.getBean(Employee.class);
        e2.display();
        System.out.println(e2.hashCode());

    }
}
