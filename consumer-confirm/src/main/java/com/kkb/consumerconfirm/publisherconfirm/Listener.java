package com.kkb.consumerconfirm.publisherconfirm;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener
public class Listener {

    @RabbitHandler
    public void handle(String msg){
        System.out.println("下单消息，内容为"+msg);
    }

}


