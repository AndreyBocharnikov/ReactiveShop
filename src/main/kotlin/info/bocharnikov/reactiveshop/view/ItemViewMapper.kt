package info.bocharnikov.reactiveshop.view

import info.bocharnikov.reactiveshop.model.Item
import org.springframework.stereotype.Component

@Component
class ItemViewMapper {

    fun toViewWithAnotherRate(good: Item, rate: Double): ItemView {
        return ItemView(
            id = good.id,
            name = good.name,
            price = good.price * rate
        )
    }

}