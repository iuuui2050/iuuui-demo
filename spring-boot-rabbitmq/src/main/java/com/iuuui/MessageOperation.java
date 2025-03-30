package com.iuuui;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author iuuui
 * @date 2024/10/21 2242
 */
@Component
public class MessageOperation {

    @RabbitListener(queuesToDeclare = {@Queue(name = "wasai")})
    public void test(String message) {
        System.err.println("[x] 消费消息 '" + message + "'");
//        System.out.println("queueName：" + queue.getName());
    }

}
