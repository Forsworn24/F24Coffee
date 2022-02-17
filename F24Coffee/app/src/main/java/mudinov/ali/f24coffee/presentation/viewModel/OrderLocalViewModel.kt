package mudinov.ali.f24coffee.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mudinov.ali.f24coffee.data.models.OrderLocalModel
import mudinov.ali.f24coffee.domain.useCase.OrderLocalUseCase

class OrderLocalViewModel (private val orderLocalUseCase: OrderLocalUseCase): ViewModel() {


    fun startInsert(nameUser:String, phoneUser:String, description:String, totalPrice:String) {
        insert(
            OrderLocalModel(0, nameUser, phoneUser, description, totalPrice)
        )
    }

    private fun insert(orderLocalModel: OrderLocalModel) = viewModelScope.launch{

        orderLocalUseCase.insert(orderLocalModel)
    }

    val loadOrder = orderLocalUseCase.loadOrder()

    fun clearOrders() = viewModelScope.launch{

        orderLocalUseCase.clear()
    }
}