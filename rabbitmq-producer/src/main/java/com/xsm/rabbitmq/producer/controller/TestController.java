package com.xsm.rabbitmq.producer.controller;

import com.xsm.rabbitmq.producer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xsm
 * @Date 2020/10/17 11:28
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/testSendMsg")
    public void sendMsg(){
        testService.sendMsg();
    }

    @RequestMapping("/testSendObj")
    public void sendObj(){
        testService.sendObj();
    }


    @RequestMapping("/testSendTopicMsg1")
    public void testSendTopicMsg1(){
        testService.testSendTopicMsg1();
    }

    @RequestMapping("/testSendTopicMsg2")
    public void testSendTopicMsg2(){
        testService.testSendTopicMsg2();
    }

}
