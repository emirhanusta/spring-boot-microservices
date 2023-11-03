package accountservice.dto;

import com.mongodb.lang.NonNull;
import org.intellij.lang.annotations.RegExp;

public record AccountRequest(
        @NonNull
        String username,
        @NonNull
        String name,
        @NonNull
        String surname,
        String email,
        String password) {
}
