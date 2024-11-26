package io.gordonpm.service;

import io.gordonpm.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaEventPublisher {

    @Autowired
    private KafkaTemplate kafkaTemplate;
    Logger log = LoggerFactory.getLogger(KafkaEventPublisher.class);


    public void sendEventToTopic(Customer customer) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("sample-topic", customer);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message=[{}] with offset=[{}]", customer.toString(), result.getRecordMetadata().offset());

            } else {
                log.error("Sent message=[{}] with offset=[{}]", customer.toString(), result.getRecordMetadata().offset());
            }
        });
    }
}
