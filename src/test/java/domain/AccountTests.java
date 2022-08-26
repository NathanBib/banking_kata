package domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountTests {
    final String firstName = "Stella";
    final String lastName = "duVésinet";
    CurrentDateTimeProvider dateTimeProvider = mock(CurrentDateTimeProvider.class);

    @Test
    void create_account() {
        // When
        when(dateTimeProvider.now()).thenReturn(LocalDateTime.of(2022, 4, 5, 9,29,0));
        final var account = new Account(firstName, lastName, dateTimeProvider);

        // Then
        assertThat(account.getFirstName()).isEqualTo(firstName);
        assertThat(account.getLastName()).isEqualTo(lastName);
        assertThat(account.balance()).isEqualTo(0.);
    }

    @Test
    void deposit() {
        // Given
        when(dateTimeProvider.now()).thenReturn(LocalDateTime.of(2022, 4, 5, 9,29,0));
        final var account = new Account(firstName, lastName, dateTimeProvider);

        // When
        account.deposit(42.);

        // Then
        assertThat(account.balance()).isEqualTo(42.);
    }

    @Test
    void withdraw() {
        // Given
        when(dateTimeProvider.now()).thenReturn(LocalDateTime.of(2022, 4, 5, 9,29,0));
        final var account = new Account(firstName, lastName, dateTimeProvider);

        // When
        account.deposit(42.);
        account.withdraw(24.);

        // Then
        assertThat(account.balance()).isEqualTo(18.);
    }

    @Test
    void print() {
        // Given
        final var account = new Account(firstName, lastName, dateTimeProvider);
        when(dateTimeProvider.now()).thenReturn(LocalDateTime.of(2022, 4, 5, 9,29,0));
        account.deposit(42.);
        when(dateTimeProvider.now()).thenReturn(LocalDateTime.of(2022, 4, 6, 9,29,0));
        account.withdraw(24.);

        // When
        String statement = account.printStatement();

        // Then
        String expected = """
                Date       Amount   Balance
                05.04.2022   42.0       42.0
                06.04.2022   -24.0      18.0
                """;
        assertThat(statement).isEqualToIgnoringWhitespace(expected);
    }
}
