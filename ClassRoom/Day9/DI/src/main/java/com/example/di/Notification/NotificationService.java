package com.example.di.Notification;

import org.springframework.stereotype.Component;

@Component
public interface NotificationService {
    public void sendMsg(String msg);
}
