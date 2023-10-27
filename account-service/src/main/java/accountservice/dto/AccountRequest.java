package accountservice.dto;

public record AccountRequest(
        String username,
        String name,
        String surname,
        String email,
        String password) {
}
