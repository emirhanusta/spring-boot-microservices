package ticketservice.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import ticketservice.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends MongoRepository<Ticket, String> {
    Optional<Ticket> findByIdAndActiveTrue(String id);

    List<Ticket> findAllByActiveTrue(PageRequest pageRequest);

}
