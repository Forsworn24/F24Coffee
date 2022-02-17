package mudinov.ali.f24coffee.domain.repository

import mudinov.ali.f24coffee.data.models.OrderLocalModel

interface OrderLocalCall {
    suspend fun insert(orderLocalModel: OrderLocalModel)
}