package mudinov.ali.f24coffee.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import mudinov.ali.f24coffee.data.models.CoffeeModel

interface CoffeeCall {
    fun loadCoffee(): LiveData<List<CoffeeModel>>
    suspend fun startMigration(context: Context)
}