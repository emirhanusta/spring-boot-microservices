package ticketservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ticketservice.dto.AccountDto;

@FeignClient(name = "account-service", path = "/api/v1/account")
public interface AccountServiceClient {

    @GetMapping("/{id}")
    ResponseEntity<AccountDto> getAccountById(@PathVariable(value = "id") String id) ;

}
