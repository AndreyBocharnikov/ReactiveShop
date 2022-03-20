package info.bocharnikov.reactiveshop.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Currency(
    @Id
    val name: String,
    val usdEquivalent: Double
)
