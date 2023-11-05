package ticketservice.dto;

import jakarta.annotation.Nonnull;

public record TicketRequest(
        @Nonnull
        String description,
        String notes,
        @Nonnull
        String assigneeId
) {

}
