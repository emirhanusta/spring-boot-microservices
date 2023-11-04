package ticketservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import ticketservice.dto.TicketDto;
import ticketservice.dto.TicketRequest;
import ticketservice.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(ticketService.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TicketDto>> getAll(@RequestParam (defaultValue = "0") int page,
                                                  @RequestParam (defaultValue = "5") int size) {
        return ResponseEntity.ok(ticketService.getAllTickets(page, size));
    }

    @PostMapping("/create")
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketRequest ticketRequest) {
        return ResponseEntity.ok(ticketService.save(ticketRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TicketDto> updateTicket(@PathVariable String id,
                                                  @RequestBody TicketRequest ticketRequest) {
        return ResponseEntity.ok(ticketService.update(id, ticketRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable String id) {
        ticketService.safeDelete(id);
        return ResponseEntity.noContent().build();
    }

}
