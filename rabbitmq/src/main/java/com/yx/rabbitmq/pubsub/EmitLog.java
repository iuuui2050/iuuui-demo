package com.yx.rabbitmq.pubsub;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author iuuui
 * @date 2024/10/20 1327
 */
public class EmitLog {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.106.138.202");
        factory.setUsername("admin");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs", BuiltinExchangeType.FANOUT);

        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, "logs", "");

        while (true) {
            System.out.print("请输入消息：");
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            if (message.equals("break")) {
                break;
            }
            channel.basicPublish("logs", "hello", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("[x] Sent '" + message + "'");
        }
        connection.close();
        channel.close();
    }

}
