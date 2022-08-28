package me.seungpang.kafkapractice.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SeungpangConsumer {

    @KafkaListener(id = "seungpang-id", topics = "seungpang")
    public void listenSeungpang(String message) {
        System.out.println(message);
    }

    @KafkaListener(id = "seungpang-bytesid", topics = "seungpang-bytes")
    public void listenSeungpangBytes(String message) {
        System.out.println(message);
    }
}
