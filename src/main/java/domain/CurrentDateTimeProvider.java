package domain;

import java.time.LocalDateTime;

@FunctionalInterface
public interface CurrentDateTimeProvider {
    static CurrentDateTimeProvider create() {
        return LocalDateTime::now;
    }

    LocalDateTime now();
}
