package com.kkb.productor;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoutingQueueTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void routingPublish(){
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0)
                rabbitTemplate.convertAndSend("route_exchange","info","info test "+ i);
            else
                rabbitTemplate.convertAndSend("route_exchange","error","error test "+ i);
        }
    }
}
