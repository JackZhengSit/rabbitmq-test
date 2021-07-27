package com.kkb.consumer.listener.simpleQueue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "simple_queue")
public class SimpleListener {
    @RabbitHandler
    public void handle(String msg){
        System.out.println("==========>"+msg);
    }
}
