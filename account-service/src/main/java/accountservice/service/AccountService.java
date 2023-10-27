package accountservice.service;

import accountservice.dto.AccountDto;
import accountservice.dto.AccountRequest;
import accountservice.exception.AccountNotFoundException;
import accountservice.model.Account;
import accountservice.repository.AccountRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDto createAccount(AccountRequest accountDto) {
        Account account = new Account(
                accountDto.username(),
                accountDto.name(),
                accountDto.surname(),
                accountDto.email(),
                accountDto.password()
        );
        Account savedAccount = accountRepository.save(account);
        return AccountDto.convertToDto(savedAccount);
    }

    public AccountDto getAccountById(String id) {
        Account account = findActiveAccountById(id);
        return AccountDto.convertToDto(account);
    }

    public List<AccountDto> getAllAccounts(int page, int size) {
        return accountRepository.findAllByActiveTrue(PageRequest.of(page, size))
                .stream()
                .map(AccountDto::convertToDto)
                .toList();
    }

    public AccountDto updateAccount(String id, AccountRequest accountDto) {
        Account account = findActiveAccountById(id);
        account.setUsername(accountDto.username());
        account.setName(accountDto.name());
        account.setSurname(accountDto.surname());
        account.setEmail(accountDto.email());
        account.setPassword(accountDto.password());
        Account savedAccount = accountRepository.save(account);
        return AccountDto.convertToDto(savedAccount);
    }
    public void safeDeleteById(String id) {
        Account account = findActiveAccountById(id);
        account.setActive(false);
        accountRepository.save(account);
    }

    private Account findActiveAccountById(String id) {
        return accountRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id: " + id ));
    }
}
