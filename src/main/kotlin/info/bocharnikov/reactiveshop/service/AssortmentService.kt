package info.bocharnikov.reactiveshop.service

import info.bocharnikov.reactiveshop.repository.ItemRepository
import info.bocharnikov.reactiveshop.view.ItemView
import info.bocharnikov.reactiveshop.view.ItemViewMapper
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.*

@Service
class AssortmentService(
    val itemRepository: ItemRepository,
    val currencyService: CurrencyService,
    val itemViewMapper: ItemViewMapper,
    val userService: UserService
) {

    fun viewForUser(userId: UUID): Flux<ItemView> {
        return userService.getUser(userId)
            .flatMap { user -> currencyService.getCurrency(user.currencyName) }
            .flatMapMany { currencyRate ->
                itemRepository.findAll()
                    .map { good -> itemViewMapper.toViewWithAnotherRate(good, currencyRate.usdEquivalent) }
            }
    }

}