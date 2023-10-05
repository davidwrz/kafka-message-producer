package au.davidwrz.kafka.infrastrucure.web;

import au.davidwrz.kafka.domain.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/messages")
class MessageController {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        var message = new Message(request.message(), LocalDateTime.now());
        kafkaTemplate.send("davidwrz", message);
    }
}
