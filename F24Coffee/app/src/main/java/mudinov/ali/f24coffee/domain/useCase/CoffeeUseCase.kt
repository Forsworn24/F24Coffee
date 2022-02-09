package mudinov.ali.f24coffee.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import mudinov.ali.f24coffee.data.models.CoffeeModel
import mudinov.ali.f24coffee.domain.repository.CoffeeCall

class CoffeeUseCase(private val coffeeCall: CoffeeCall) {
    fun loadCoffee(): LiveData<List<CoffeeModel>> {

        return coffeeCall.loadCoffee()
    }

    suspend fun startMigration (context: Context) {

        coffeeCall.startMigration(context)
    }
}