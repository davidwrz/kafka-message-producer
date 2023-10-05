package au.davidwrz.kafka.domain;

import java.time.LocalDateTime;

public record Message(String message, LocalDateTime created) {
}
