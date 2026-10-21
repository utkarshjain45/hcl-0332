package com.example.di.Notification;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Student s = ctx.getBean(Student.class);
        Student s1 = ctx.getBean(Student.class);
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
//        s.notifyStudent();
        ctx.close();
    }
}
