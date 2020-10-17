package com.xsm.rabbitmq.consumer.mq;

import com.xsm.rabbitmq.body.TestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author xsm
 * @Date 2020/10/17 11:58
 */
@Slf4j
@Component
public class ObjConsumer {

    @RabbitListener(queuesToDeclare = @Queue("test_obj_queue"))
    @RabbitHandler
    public void process(@Payload TestBody body){
        log.info("消息体: {}", body);
        log.info("开始消费...");
        log.info("消费结束");
    }

}
