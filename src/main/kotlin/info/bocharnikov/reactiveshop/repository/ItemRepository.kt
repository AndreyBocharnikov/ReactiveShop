package info.bocharnikov.reactiveshop.repository

import info.bocharnikov.reactiveshop.model.Item
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.UUID

interface ItemRepository: ReactiveCrudRepository<Item, UUID>