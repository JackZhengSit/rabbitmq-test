package com.kkb.productor;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WorkQueueTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void workProducer(){
        for (int i = 0; i < 1000; i++) {
            rabbitTemplate.convertAndSend("work_queue","hello rabbit"+i);
        }
    }
}
