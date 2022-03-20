package info.bocharnikov.reactiveshop.view

import java.util.UUID


data class ItemView(
    val id: UUID,
    val name: String,
    val price: Double
)