package com.learning.demo.event.listener;

import com.learning.demo.event.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        String message = event.getMessage();
        Object source = event.getSource();
        System.out.println(source + message);

    }
}
