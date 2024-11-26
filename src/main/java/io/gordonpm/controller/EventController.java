package io.gordonpm.controller;

import io.gordonpm.dto.Customer;
import io.gordonpm.service.KafkaEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private KafkaEventPublisher publisher;

    @PostMapping("/publish")
    public void sendEvent(@RequestBody Customer customer) {
        publisher.sendEventToTopic(customer);
    }
}
