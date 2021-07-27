package com.kkb.productor;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PublishSubscribe {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void publisher(){
        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertAndSend("fanout_exchange","","hello rabbit"+i);
        }
    }
}
