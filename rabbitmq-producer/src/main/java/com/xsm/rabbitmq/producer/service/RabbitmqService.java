package com.xsm.rabbitmq.producer.service;

import com.xsm.rabbitmq.enums.RabbitmqMsgEnum;

/**
 * @author xsm
 * @Date 2020/10/17 11:40
 * rabbitmq service
 */
public interface RabbitmqService {

    boolean sendMessage(RabbitmqMsgEnum rabbitmqMsgEnum, Object msg);
}
