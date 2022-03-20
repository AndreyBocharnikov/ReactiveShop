package info.bocharnikov.reactiveshop.repository

import info.bocharnikov.reactiveshop.model.Currency
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface CurrencyRepository: ReactiveCrudRepository<Currency, String> {

    fun findByName(name: String): Mono<Currency>

    fun existsByName(name: String): Mono<Boolean>

}