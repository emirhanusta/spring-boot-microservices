package accountservice.repository;

import accountservice.model.Account;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {
    Optional<Account> findByIdAndActiveTrue(String id);

    List<Account> findAllByActiveTrue(PageRequest pageRequest);

}
