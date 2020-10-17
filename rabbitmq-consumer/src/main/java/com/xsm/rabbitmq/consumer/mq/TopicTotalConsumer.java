package com.xsm.rabbitmq.consumer.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author xsm
 * @Date 2020/10/17 14:30
 */
@Slf4j
@Component
@RabbitListener(queues = "topic.woman")
public class TopicTotalConsumer {

    @RabbitHandler
    public void process(Map message){

        log.info("TopicTotalConsumer 消费者收到: {}", message);
    }

}
