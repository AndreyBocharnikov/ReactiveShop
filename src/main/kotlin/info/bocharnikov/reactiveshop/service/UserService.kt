package info.bocharnikov.reactiveshop.service

import info.bocharnikov.reactiveshop.model.User
import info.bocharnikov.reactiveshop.repository.CurrencyRepository
import info.bocharnikov.reactiveshop.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import java.util.*

@Service
class UserService(
    val repository: UserRepository,
    val currencyRepository: CurrencyRepository
) {

    fun createUser(currencyName: String): Mono<UUID> {
        return Mono.just(currencyName)
            .filterWhen { currencyRepository.existsByName(it) }
            .switchIfEmpty { Mono.error { IllegalStateException(currencyName) } }
            .flatMap { repository.save(User(UUID.randomUUID(), currencyName)) }
            .map { it.id }
    }

    fun getUser(id: UUID): Mono<User> {
        return repository.findById(id)
            .switchIfEmpty {
                Mono.error { IllegalStateException(id.toString()) }
            }
    }
}