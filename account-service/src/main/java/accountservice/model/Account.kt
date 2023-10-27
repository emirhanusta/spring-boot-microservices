package accountservice.model

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "accounts")
data class Account @JvmOverloads constructor(

    val id: String = UUID.randomUUID().toString(),
    var username: String,
    var name: String,
    var surname: String,
    var email: String,
    var password: String,
    var active: Boolean? = true
)