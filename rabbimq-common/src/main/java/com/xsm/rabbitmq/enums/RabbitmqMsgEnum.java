package com.xsm.rabbitmq.enums;

import lombok.Getter;

/**
 * @author xsm
 * @Date 2020/10/17 11:43
 */
@Getter
public enum RabbitmqMsgEnum {

    TEST_DIRECT_MSG("test_direct_exchange", "test_routing_key", "test_queue"),

    TEST_DIRECT_OBJ("test_direct_exchange", "test_obj_routing_key", "test_obj_queue"),

    TEST_TOPIC_MSG("test_topic_exchange", "topic.man", "topic.man"),

    TEST_TOPIC_OBJ("test_topic_exchange", "topic.#", "topic.woman"),

    ;

    private String exchange;

    private String routingKey;

    private String queue;

    RabbitmqMsgEnum(String exchange, String routingKey, String queue) {
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.queue = queue;
    }
}
