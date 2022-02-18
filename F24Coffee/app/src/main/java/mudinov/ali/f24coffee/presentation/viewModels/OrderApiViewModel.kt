package mudinov.ali.f24coffee.presentation.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mudinov.ali.f24coffee.domain.useCase.OrderApiUseCase

class OrderApiViewModel(private val orderApiUseCase: OrderApiUseCase): ViewModel() {

    fun insert(context: Context, name:String, phone:String, description:String, priceOrder:String) = viewModelScope.launch {
        orderApiUseCase.insert(context, name, phone, description, priceOrder)

    }
}