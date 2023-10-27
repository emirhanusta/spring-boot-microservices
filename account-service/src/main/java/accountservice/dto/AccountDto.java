package accountservice.dto;

import accountservice.model.Account;

public record AccountDto(
        String id,
        String username,
        String name,
        String surname,
        String email,
        String password
) {
    public static AccountDto convertToDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getUsername(),
                account.getName(),
                account.getSurname(),
                account.getEmail(),
                account.getPassword()
        );
    }
}
