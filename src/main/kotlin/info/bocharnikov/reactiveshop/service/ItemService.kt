package info.bocharnikov.reactiveshop.service

import info.bocharnikov.reactiveshop.model.Item
import info.bocharnikov.reactiveshop.repository.ItemRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

@Service
class ItemService(
    val goodRepository: ItemRepository
) {

    fun createGood(price: Double, name: String): Mono<UUID> {
        return goodRepository.save(Item(UUID.randomUUID(), price, name))
            .map { it.id }
    }
}