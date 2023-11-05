package ticketservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Account not found", value = HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException{

    private ExceptionMessage exceptionMessage;

    public AccountNotFoundException(ExceptionMessage message) {
        this.exceptionMessage = message;
    }

    public ExceptionMessage getExceptionMessage() {
        return exceptionMessage;
    }
}
