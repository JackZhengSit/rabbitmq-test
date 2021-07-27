package com.kkb.productor;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleQueueTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void product(){
        rabbitTemplate.convertAndSend("simple_queue","hello rabbit");
    }
}
