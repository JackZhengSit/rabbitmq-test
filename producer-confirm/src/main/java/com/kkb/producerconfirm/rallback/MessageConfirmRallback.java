package com.kkb.producerconfirm.rallback;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageConfirmRallback implements RabbitTemplate.ConfirmCallback ,RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void initRabbitTemplate(){
        rabbitTemplate.setConfirmCallback(this::confirm);
        rabbitTemplate.setReturnsCallback(this::returnedMessage);
    }

    /**
     *
     * @param correlationData
     * @param ack
     * @param msg
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String msg) {
        if(ack){
            System.out.println("消息进入exchange成功");
        }else{
            System.out.println("消息进入exchange失败,错误原因"+msg);
        }
    }

    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        System.out.println("消息从交换机进入队列失败：>>>>>>>");
        System.out.println("exchange = " + returnedMessage.getExchange());
        System.out.println("replyCode = " + returnedMessage.getReplyCode());
        System.out.println("replyText = " + returnedMessage.getReplyText());
        System.out.println("routingKey = " + returnedMessage.getRoutingKey());
    }
}
