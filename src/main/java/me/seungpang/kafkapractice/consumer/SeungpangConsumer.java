package me.seungpang.kafkapractice.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class SeungpangConsumer {

    @KafkaListener(id = "seungpang-id", topics = "seungpang")
    public void listenSeungpang(String message) {
        System.out.println(message);
    }

    @KafkaListener(id = "seungpang-bytes-id", topics = "seungpang-bytes")
    public void listenSeungpangBytes(String message) {
        System.out.println(message);
    }

    @KafkaListener(id = "seungpang-request-id", topics = "seungpang-request")
    @SendTo
    public String listenSeungpangRequest(String message) {
        System.out.println(message);
        return "Pong Seungpang";
    }
}
