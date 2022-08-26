package domain;

import java.time.LocalDateTime;

public record Operation(LocalDateTime dateTime, double amount) {
}
