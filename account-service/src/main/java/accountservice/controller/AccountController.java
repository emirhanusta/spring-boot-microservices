package accountservice.controller;

import accountservice.service.AccountService;
import accountservice.dto.AccountDto;
import accountservice.dto.AccountRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable String id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AccountDto>> getAllAccounts(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(accountService.getAllAccounts(page, size));
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountRequest request) {
        return ResponseEntity.ok(accountService.createAccount(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable String id, @RequestBody AccountRequest request) {
        return ResponseEntity.ok(accountService.updateAccount(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id) {
        accountService.safeDeleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
