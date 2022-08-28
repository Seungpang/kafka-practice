package me.seungpang.kafkapractice;

import java.nio.charset.StandardCharsets;
import me.seungpang.kafkapractice.producer.SeungpangProducer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPracticeApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(SeungpangProducer seungpangProducer) {
        return args -> {
            seungpangProducer.async("seungpang", "Hello, seungpang-async");
            seungpangProducer.sync("seungpang", "Hello, seungpang-sync");
            seungpangProducer.routingSend("seungpang", "Hello, seungpang-routing");
            seungpangProducer.routingSend("seungpang-bytes", "Hello, seungpang-bytes".getBytes(StandardCharsets.UTF_8));
        };
    }
}
