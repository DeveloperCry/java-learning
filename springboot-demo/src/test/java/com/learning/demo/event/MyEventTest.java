package com.learning.demo.event;

import com.learning.demo.event.listener.MyListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationEventPublisher.class, MyListener.class})
public class MyEventTest {
    @Autowired
    private ApplicationEventPublisher publisher;

    @Test
    public void testMyEvent() {
        MyEvent myEvent = new MyEvent("hello", " world");
        publisher.publishEvent(myEvent);
    }
}
