package au.davidwrz.kafka.application;

import au.davidwrz.kafka.domain.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class KafkaListeners {

    @KafkaListener(topics = "davidwrz", groupId = "groupId")
    void listener(Message data) {
        System.out.println("Listener received data: " + data);
    }
}
