package app.controller;

import domain.Account;
import domain.CurrentDateTimeProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    List<Account> accounts = new ArrayList<>();

    Account testAccount = new Account("Titi", "duVésinet", CurrentDateTimeProvider.create());

    @GetMapping("/statement")
    public void getStatement() {
        System.out.println("pouet");
    }

    @GetMapping("/test")
    public ResponseEntity<NameDto> getTest() {
        return ResponseEntity.of(Optional.of(new NameDto(
                testAccount.getFirstName() + testAccount.getLastName())
                )
        );
    }

    @PostMapping("/create-account")
    public void createAccount(@RequestBody Account account) {
        accounts.add(account);
    }

    @GetMapping("/get-account{id}")
    public Account getAccount(@PathVariable int id) {
        return accounts.get(id);
    }
}
