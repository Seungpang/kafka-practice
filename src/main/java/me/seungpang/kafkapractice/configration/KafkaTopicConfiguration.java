package me.seungpang.kafkapractice.configration;

import static org.apache.kafka.clients.admin.AdminClient.*;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaAdmin.NewTopics;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public AdminClient adminClient(KafkaAdmin kafkaAdmin) {
        return create(kafkaAdmin.getConfigurationProperties());
    }

    @Bean
    public NewTopic seungpang() {
        return TopicBuilder.name("seungpang").build();
    }

    @Bean
    public NewTopics seungpangs() {
        return new NewTopics(
                TopicBuilder.name("seungpang-part1").build(),
                TopicBuilder.name("seungpang-part2")
                        .partitions(3)
                        .replicas(1)
                        .config(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(1000 * 60 * 60))
                        .build()
        );
    }
}
