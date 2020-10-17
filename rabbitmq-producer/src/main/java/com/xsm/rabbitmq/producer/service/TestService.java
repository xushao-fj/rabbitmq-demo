package com.xsm.rabbitmq.producer.service;

import com.xsm.rabbitmq.body.TestBody;
import com.xsm.rabbitmq.enums.RabbitmqMsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author xsm
 * @Date 2020/10/17 11:54
 */
@Service
public class TestService {

    @Autowired
    private RabbitmqService rabbitmqService;

    public void sendMsg(){
        for (int i = 1; i <= 1000; i ++){
            String msg = "第" + i + "消息";
            rabbitmqService.sendMessage(RabbitmqMsgEnum.TEST_DIRECT_MSG, msg);
        }
    }

    public void sendObj() {
        for (int i = 1; i <= 1000; i ++){
            String msg = "第" + i + "消息";

            rabbitmqService.sendMessage(RabbitmqMsgEnum.TEST_DIRECT_OBJ, new TestBody(i, msg));
        }
    }

    public void testSendTopicMsg1() {
        for (int i = 1; i <= 10; i ++){
            String msg = "第" + i + "topic man 消息";
            Map<String, Object> map = new HashMap<>();
            map.put("messageId", UUID.randomUUID().toString().replace("-", ""));
            map.put("messageData", msg);
            map.put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            rabbitmqService.sendMessage(RabbitmqMsgEnum.TEST_TOPIC_MSG, map);
        }
    }

    public void testSendTopicMsg2() {
        for (int i = 1; i <= 10; i ++){
            String msg = "第" + i + "topic woman 消息";
            Map<String, Object> map = new HashMap<>();
            map.put("messageId", UUID.randomUUID().toString().replace("-", ""));
            map.put("messageData", msg);
            map.put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            rabbitmqService.sendMessage(RabbitmqMsgEnum.TEST_TOPIC_OBJ, map);
        }
    }
}
