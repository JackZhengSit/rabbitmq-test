package com.kkb.consumer.listener.publishSubscribe;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout_queue2")
public class SubscribeListener2 {

    @RabbitHandler
    public void subscribe(String msg){
        System.out.println("=======subscribe2=======>"+msg);
    }
}
