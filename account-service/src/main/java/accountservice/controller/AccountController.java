package accountservice.controller;

import accountservice.service.AccountService;
import accountservice.dto.AccountDto;
import accountservice.dto.AccountRequest;
import com.mongodb.lang.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable @NonNull String id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AccountDto>> getAllAccounts(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(accountService.getAllAccounts(page, size));
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createAccount(@Validated @RequestBody AccountRequest request) {
        return ResponseEntity.ok(accountService.createAccount(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable String id,@Validated @RequestBody AccountRequest request) {
        return ResponseEntity.ok(accountService.updateAccount(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id) {
        accountService.safeDeleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
