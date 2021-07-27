package com.kkb.consumer.listener.workQueue;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "work_queue")
public class WorkListener1 {

    @RabbitHandler
    public void workHandler(String msg){
        System.out.println("====work_queue_listener1======>"+msg);
    }
}
