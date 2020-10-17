package com.xsm.rabbitmq.producer.config;

import com.xsm.rabbitmq.enums.RabbitmqMsgEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.xsm.rabbitmq.enums.RabbitmqMsgEnum.*;

/**
 * @author xsm
 * @Date 2020/10/17 11:27
 * rabbitmq 配置
 */
@Configuration
public class RabbitmqConfig{

    /** 直连交换机*/
    private final static String DIRECT_EXCHANGE = "test_direct_exchange";

    /** topic交换机*/
    private final static String TOPIC_EXCHANGE = "test_topic_exchange";

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

    /**
     * 初始化交换机
     * 直连型交换机: 根据消息携带的路由键将消息投递给对应的队列
     * 流程: 有一个队列绑定到一个直连交换机上,同时赋予一个路由键 routing key.
     *       然后当一个消息携带者路由值X, 这个消息通过生产者发送给交换机, 交换机就会根据
     *       这个路由值X去寻找绑定值也是X的队列
     * @return
     */
    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(DIRECT_EXCHANGE, true, false);
    }

    /**
     * topic交换机
     * 与直连交换机流程差不多, 特点在于它的路由键和绑定键之间是有规则的
     *         规则   * 用来表示一个单词(必须出现的)
     *               # 用来表示任意数量(零个或多个)单词
     *         ex:   队列Q1 -> 绑定键 *.TT.*, 则一条消息携带的路由键 A.TT.B, 那么会发送到Q1
     *               队列Q2 -> 绑定键 TT.#, 则一条消息携带的路由键 TT.AA.BB, 那么会发送到Q2
     * @return
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Queue topicFirstQueue(){
        return new Queue(TEST_TOPIC_MSG.getQueue());
    }

    @Bean
    public Queue topicSecondQueue(){
        return new Queue(TEST_TOPIC_OBJ.getQueue());
    }

    /**
     * 队列通过路由键绑定到交换机
     * @return
     */
    @Bean
    public Binding topicFirstBinding(){
        return BindingBuilder.bind(topicFirstQueue()).to(topicExchange()).with(TEST_TOPIC_MSG.getRoutingKey());
    }

    /**
     * 队列通过路由键绑定到交换机
     * @return
     */
    @Bean
    public Binding topicSecondBinding(){
        return BindingBuilder.bind(topicSecondQueue()).to(topicExchange()).with(TEST_TOPIC_OBJ.getRoutingKey());
    }

    /**
     * 队列通过路由键绑定到交换机
     * @return
     */
    @Bean
    public Binding msgBinding(){
        return BindingBuilder.bind(msgQueue()).to(exchange()).with(TEST_DIRECT_MSG.getRoutingKey());
    }

    /**
     * 队列通过路由键绑定到交换机
     * @return
     */
    @Bean
    public Binding objBinding(){
        return BindingBuilder.bind(msgQueue()).to(exchange()).with(TEST_DIRECT_OBJ.getRoutingKey());
    }





}
