package mudinov.ali.f24coffee.presentation.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mudinov.ali.f24coffee.domain.useCase.CoffeeUseCase

class CoffeeViewModel(private val coffeeUseCase: CoffeeUseCase): ViewModel() {

    val loadCoffee = coffeeUseCase.loadCoffee()

    fun migration(context: Context) = viewModelScope.launch {
        coffeeUseCase.startMigration(context)
    }
}