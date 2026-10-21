package com.example.di.Notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements NotificationService{

    @Override
    public void sendMsg(String msg) {
        System.out.println("Email Service: " + msg);
    }
}
