package mudinov.ali.f24coffee.data.dataSource

import androidx.lifecycle.LiveData
import mudinov.ali.f24coffee.data.models.CoffeeModel

interface CoffeeDataSource {
    fun insert(coffeeModel: CoffeeModel)
    fun loadCoffee():LiveData<List<CoffeeModel>>
    suspend fun clear()
}