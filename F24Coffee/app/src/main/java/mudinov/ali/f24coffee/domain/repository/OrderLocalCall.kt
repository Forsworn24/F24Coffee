package mudinov.ali.f24coffee.domain.repository

import androidx.lifecycle.LiveData
import mudinov.ali.f24coffee.data.models.OrderLocalModel

interface OrderLocalCall {
    suspend fun insert(orderLocalModel: OrderLocalModel)

    fun loadOrder(): LiveData<List<OrderLocalModel>>

    suspend fun clear()
}