package accountservice.model

import com.mongodb.lang.NonNull
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "accounts")
data class Account @JvmOverloads constructor(

    val id: String = UUID.randomUUID().toString(),
    @NonNull
    var username: String,
    @NonNull
    var name: String,
    @NonNull
    var surname: String,

    var email: String,
    var password: String,
    var active: Boolean? = true
)