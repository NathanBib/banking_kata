package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Account {
    private final String firstName;
    private final String lastName;
    private double balance;
    private final List<Operation> operations;
    private final CurrentDateTimeProvider dateTimeProvider;

    public Account(String firstName, String lastName, CurrentDateTimeProvider dateTimeProvider) {
        this.firstName = firstName;
        this.lastName = lastName;
        balance = 0.;
        operations = new ArrayList<>();
        this.dateTimeProvider = dateTimeProvider;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double balance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.operations.add(new Operation(dateTimeProvider.now(), amount));
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        this.operations.add(new Operation(dateTimeProvider.now(), -amount));
    }

    public String printStatement() {
        final String header = "Date" + "\t" + "Amount" + "\t" + "Balance\n";
        List<String> statements = new ArrayList<>();
        double currentBalance = 0.;
        for (Operation operation : operations
                .stream()
                .sorted(Comparator.comparing(Operation::dateTime))
                .toList()) {
            currentBalance += operation.amount();
            statements.add(formattedDate(operation.dateTime()) +
                    "\t" + operation.amount() + "\t" + currentBalance);
        }
        return header + String.join("\n", statements);
    }

    private String formattedDate(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        return formatter.format(dateTime);
    }
}
