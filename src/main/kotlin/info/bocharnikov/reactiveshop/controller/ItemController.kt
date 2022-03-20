package info.bocharnikov.reactiveshop.controller

import info.bocharnikov.reactiveshop.service.AssortmentService
import info.bocharnikov.reactiveshop.service.ItemService
import info.bocharnikov.reactiveshop.view.ItemView
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/api/goods")
class ItemController(
    val assortmentService: AssortmentService,
    val goodService: ItemService,
) {

    @PostMapping
    fun create(@RequestParam price: Double, @RequestParam name: String): Mono<UUID> {
        return goodService.createGood(price, name)
    }

    @GetMapping("/all/user/{userId}")
    fun getAssortment(@PathVariable userId: UUID): Flux<ItemView> {
        return assortmentService.viewForUser(userId)
    }

}