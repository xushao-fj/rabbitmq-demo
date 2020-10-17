package com.xsm.rabbitmq.consumer.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xsm
 * @Date 2020/10/17 11:58
 */
@Slf4j
@Component
public class TestConsumer {

    @RabbitListener(queues = "test_queue")
    public void process(String msg){
        log.info("消息体: {}", msg);
        log.info("开始消费...");
        log.info("消费结束");
    }

}
