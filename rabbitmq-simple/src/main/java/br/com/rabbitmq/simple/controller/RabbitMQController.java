package br.com.rabbitmq.simple.controller;

import br.com.rabbitmq.simple.service.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        rabbitMQProducer.sendMessage(message);
        return "Message sent to RabbitMQ!";
    }

}
