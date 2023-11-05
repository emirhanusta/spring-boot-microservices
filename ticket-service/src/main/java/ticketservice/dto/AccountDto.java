package ticketservice.dto;

public record AccountDto(
        String id,
        String username,
        String name,
        String surname,
        String email,
        String password
) {
}