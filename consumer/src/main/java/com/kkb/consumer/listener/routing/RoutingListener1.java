package com.kkb.consumer.listener.routing;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "route_queue1")
public class RoutingListener1 {
    @RabbitHandler
    public void infoListener(String msg){
        System.out.println("info listener======>" + msg);
    }
}
