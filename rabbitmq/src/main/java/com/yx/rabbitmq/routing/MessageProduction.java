package com.yx.rabbitmq.routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author iuuui
 * @date 2024/10/20 1348
 */
public class MessageProduction {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.106.138.202");
        factory.setUsername("admin");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 绑定交换机
        channel.exchangeDeclare("logs_direct", BuiltinExchangeType.DIRECT);

        while (true) {
            System.out.print("请输入消息：");
            Scanner scanner = new Scanner(System.in);
            String content = scanner.nextLine();
            if (content.equals("break")) {
                break;
            }
            String[] strings = content.split(",");
            String message = strings[0];
            String routingKey = strings[1];
            // 向 logs_direct 交换机的 routingKey 队列发送消息
            channel.basicPublish("logs_direct", routingKey, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("[x] Sent '" + message + "'");
        }
        connection.close();
        channel.close();
    }

}
