package me.seungpang.kafkapractice;

import java.util.Collections;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.clients.admin.TopicListing;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPracticeApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(AdminClient adminClient) {
        return args -> {
            final Map<String, TopicListing> topics = adminClient.listTopics().namesToListings().get();
            for (String topicName : topics.keySet()) {
                final TopicListing topicListing = topics.get(topicName);
                System.out.println(topicListing);

                final Map<String, TopicDescription> descriptionMap = adminClient.describeTopics(
                        Collections.singleton(topicName)).allTopicNames().get();
                System.out.println(descriptionMap);

                if (!topicListing.isInternal()) {
                    adminClient.deleteTopics(Collections.singleton(topicName));
                }
            }
        };
    }
}
