package com.yx.rabbitmq.pubsub;

import com.rabbitmq.client.*;

/**
 * @author iuuui
 * @date 2024/10/20 1335
 */
public class ReceiveLogs {

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.106.138.202");
        factory.setUsername("admin");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs", BuiltinExchangeType.FANOUT);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, "logs", "");
        DeliverCallback deliverCallback = ((consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("消费消息：" + message);
        });
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});
    }

}
