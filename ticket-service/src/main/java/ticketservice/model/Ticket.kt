package ticketservice.model

import com.mongodb.lang.NonNull
import org.intellij.lang.annotations.Pattern
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date
import java.util.UUID

@Document(collection = "tickets")
data class Ticket @JvmOverloads constructor(

        @Id
        val id: String = UUID.randomUUID().toString(),
        @NonNull
        var description: String,
        var notes: String,
        @NonNull
        var assignee: String,
        var active: Boolean? = true,
        @CreatedDate
        var createdDate: Date? = null,
        @LastModifiedDate
        var updatedDate: Date? = null
)