package com.kkb.consumer.listener.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic_queue2")
public class TopicListener2 {
    @RabbitHandler
    public void handle(String msg){
        System.out.println("item.# listener====>"+msg);
    }
}
