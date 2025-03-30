package com.iuuui;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

/**
 * @author iuuui
 * @date 2024/10/20 2221
 */
@RestController
@RequestMapping(value = "/rabbitMQ")
public class RabbitMQController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping(value = "/send")
    public String send(String msg) {
        Message message = new Message(msg.getBytes(StandardCharsets.UTF_8));
        rabbitTemplate.send("wasai", message);
        return "ok";
    }

}
