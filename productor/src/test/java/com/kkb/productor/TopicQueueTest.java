package com.kkb.productor;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TopicQueueTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void topicPublish(){
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0)
                rabbitTemplate.convertAndSend("topic_exchange","item.insert","hello rabbit"+i);
            else
                rabbitTemplate.convertAndSend("topic_exchange","item.insert.abc","hello rabbit" +i);
        }
    }
}
