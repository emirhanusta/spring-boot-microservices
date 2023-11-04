package ticketservice.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ticketservice.dto.TicketDto;
import ticketservice.dto.TicketRequest;
import ticketservice.exception.TicketNotFoundException;
import ticketservice.model.Ticket;
import ticketservice.repository.TicketRepository;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TicketDto getById(String id) {
        Ticket ticket = findById(id);
        return TicketDto.convertToDto(ticket);
    }

    public List<TicketDto> getAllTickets(int page, int size) {
        List<Ticket> tickets = ticketRepository.findAllByActiveTrue(PageRequest.of(page, size));
        return tickets.stream()
                .map(TicketDto::convertToDto)
                .toList();
    }

    public TicketDto save(TicketRequest ticketRequest) {
        Ticket newTicket = new Ticket(
                ticketRequest.description(),
                ticketRequest.notes(),
                ticketRequest.assignee()
        );
        Ticket savedTicket = ticketRepository.save(newTicket);
        return TicketDto.convertToDto(savedTicket);
    }

    public TicketDto update(String id, TicketRequest ticketRequest) {
        Ticket ticket = findById(id);
        ticket.setDescription(ticketRequest.description());
        ticket.setNotes(ticketRequest.notes());
        ticket.setAssignee(ticketRequest.assignee());
        Ticket updatedTicket = ticketRepository.save(ticket);
        return TicketDto.convertToDto(updatedTicket);
    }

    public void safeDelete(String id) {
        Ticket ticket = findById(id);
        ticket.setActive(false);
        ticketRepository.save(ticket);
    }

    private Ticket findById(String id) {
        return ticketRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new TicketNotFoundException("Ticket not found with id: " + id + "."));
    }
}
