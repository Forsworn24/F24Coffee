package mudinov.ali.f24coffee.data.repository

import androidx.lifecycle.LiveData
import mudinov.ali.f24coffee.data.localDB.OrderLocalDao
import mudinov.ali.f24coffee.data.models.OrderLocalModel
import mudinov.ali.f24coffee.domain.repository.OrderLocalCall

class OrderLocalRepository(private val orderLocalDao: OrderLocalDao
): OrderLocalCall {

    override suspend fun insert(orderLocalModel: OrderLocalModel) {
        orderLocalDao.insert(orderLocalModel)   }

    override fun loadOrder(): LiveData<List<OrderLocalModel>> {
        return orderLocalDao.loadOrder()    }

    override suspend fun clear() {
        orderLocalDao.clear()    }
}