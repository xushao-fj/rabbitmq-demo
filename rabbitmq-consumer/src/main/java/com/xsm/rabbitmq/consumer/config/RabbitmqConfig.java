package com.xsm.rabbitmq.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.xsm.rabbitmq.enums.RabbitmqMsgEnum.*;

/**
 * @author xsm
 * @Date 2020/10/17 14:41
 * 声明队列
 */
@Configuration
public class RabbitmqConfig {

    /**
     * 初始化队列
     * @return
     */
    @Bean
    public Queue msgQueue(){
        return new Queue(TEST_DIRECT_MSG.getQueue(), true);
    }

    /**
     * 初始化队列
     * @return
     */
    @Bean
    public Queue objQueue(){
        // durable: 是否持久化, 默认是false, 持久化队列: 会被存储在磁盘上, 当消息代理重启时仍然存在, 暂存队列: 当前链接有效
        // exclusive: 默认false, 只能被当前创建的链接使用, 而且当链接关闭后队列即被删除. 此参考优先级高于durable
        // autoDelete: 是否自动删除, 当没有生产者或消费者使用此队列, 该队列会自动删除
        // 一般设置以下队列的持久化就可以,其余两个默认false
        return new Queue(TEST_DIRECT_OBJ.getQueue(), true);
    }


    @Bean
    public Queue topicFirstQueue(){
        return new Queue(TEST_TOPIC_MSG.getQueue());
    }

    @Bean
    public Queue topicSecondQueue(){
        return new Queue(TEST_TOPIC_OBJ.getQueue());
    }
}
