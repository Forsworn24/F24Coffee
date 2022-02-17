package mudinov.ali.f24coffee.domain.useCase

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mudinov.ali.f24coffee.data.models.CardModel
import mudinov.ali.f24coffee.data.models.OrderLocalModel
import mudinov.ali.f24coffee.domain.repository.CardCall
import mudinov.ali.f24coffee.domain.repository.OrderLocalCall

class OrderLocalUseCase (private val orderLocalCall: OrderLocalCall) {

    suspend fun insert(orderLocalModel: OrderLocalModel) {
        orderLocalCall.insert(orderLocalModel)    }
}