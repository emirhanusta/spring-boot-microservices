package ticketservice.dto;

import ticketservice.model.Ticket;

public record TicketDto(
        String id,
        String description,
        String notes,
        String assigneeId
) {
    public static TicketDto convertToDto(Ticket ticket) {
        return new TicketDto(
                ticket.getId(),
                ticket.getDescription(),
                ticket.getNotes(),
                ticket.getAssigneeId()
        );
    }
}

