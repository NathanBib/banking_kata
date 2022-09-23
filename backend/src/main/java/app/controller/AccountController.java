package app.controller;

import domain.Account;
import domain.CurrentDateTimeProvider;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    List<Account> accounts = new ArrayList<>();

    Account testAccount = new Account("Titi", "duVésinet", CurrentDateTimeProvider.create());

    @GetMapping("/statement/")
    public void getStatement() {
        System.out.println("pouet");
    }

    @GetMapping("/test")
    public String getTest() {
        return testAccount.getFirstName() + testAccount.getLastName();
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
