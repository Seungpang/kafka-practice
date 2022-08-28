package me.seungpang.kafkapractice.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin.NewTopics;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopics seungpangs() {
        return new NewTopics(
                TopicBuilder.name("seungpang").build(),
                TopicBuilder.name("seungpang-bytes").build()
        );
    }
}
