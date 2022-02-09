package mudinov.ali.f24coffee.data.dataSourceIMPL

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mudinov.ali.f24coffee.data.dataSource.CoffeeDataSource
import mudinov.ali.f24coffee.data.localDB.CoffeeDao
import mudinov.ali.f24coffee.data.models.CoffeeModel

class CoffeeDataSourceIMPL(private val dao: CoffeeDao): CoffeeDataSource {

    override fun insert(coffeeModel: CoffeeModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(coffeeModel) }

    }

    override fun loadCoffee(): LiveData<List<CoffeeModel>> {
        return dao.loadCoffee()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear() }
    }

}