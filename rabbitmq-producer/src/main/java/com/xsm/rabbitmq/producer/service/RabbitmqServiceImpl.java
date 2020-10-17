package com.xsm.rabbitmq.producer.service;

import com.alibaba.fastjson.JSON;
import com.xsm.rabbitmq.enums.RabbitmqMsgEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xsm
 * @Date 2020/10/17 11:47
 */
@Slf4j
@Component
public class RabbitmqServiceImpl implements RabbitmqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public boolean sendMessage(RabbitmqMsgEnum rabbitmqMsgEnum, Object msg) {
        String strMsg = JSON.toJSONString(msg);
        log.info("发送 queue: {}, msg: {}", rabbitmqMsgEnum.getQueue(), msg);
        try {
            rabbitTemplate.convertAndSend(rabbitmqMsgEnum.getExchange(), rabbitmqMsgEnum.getRoutingKey(), msg);
        } catch (AmqpException e) {
            log.info("发送 消息失败, msgEnum: {}, msg: {}, e: {}", rabbitmqMsgEnum, msg, e.getMessage());
            return false;
        }
        return true;
    }
}
