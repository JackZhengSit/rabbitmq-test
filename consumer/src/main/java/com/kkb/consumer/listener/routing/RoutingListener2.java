package com.kkb.consumer.listener.routing;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "route_queue2")
public class RoutingListener2 {
    @RabbitHandler
    public void infoListener(String msg){
        System.out.println("error listener======>" + msg);
    }
}
