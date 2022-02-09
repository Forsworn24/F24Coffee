package mudinov.ali.f24coffee.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import mudinov.ali.f24coffee.data.dataSource.CoffeeApiDataSource
import mudinov.ali.f24coffee.data.dataSource.CoffeeDataSource
import mudinov.ali.f24coffee.data.models.CoffeeModel
import mudinov.ali.f24coffee.domain.repository.CoffeeCall

class CoffeeRepository(private val coffeeApiDataSource: CoffeeApiDataSource,
                       private val coffeeDataSource: CoffeeDataSource
): CoffeeCall {

    override fun loadCoffee(): LiveData<List<CoffeeModel>> {
        return coffeeDataSource.loadCoffee()
    }

    override suspend fun startMigration(context: Context) {
        coffeeDataSource.clear()
        coffeeApiDataSource.startMigration(context)
    }

}