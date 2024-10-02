package br.com.m.web_socket_basic.controller;

import br.com.m.web_socket_basic.message.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class WebSocketController {

    @MessageMapping("/send-message")
    @SendTo("/topic/messages")
    public MessageDTO sendMessage(MessageDTO message) {
        log.info("Mensagem recebida: {} de {}", message.getContent(), message.getUsername());
        return message;
    }

}
