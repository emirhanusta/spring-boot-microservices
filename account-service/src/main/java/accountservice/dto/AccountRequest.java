package accountservice.dto;

import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.core.index.Indexed;

public record AccountRequest(
        @NonNull
        @Indexed(unique = true)
        String username,
        @NonNull
        String name,
        @NonNull
        String surname,
        String email,
        String password) {
}
