package mudinov.ali.f24coffee.domain.repository

import androidx.lifecycle.LiveData
import mudinov.ali.f24coffee.data.models.CardModel

interface CardCall {

    suspend fun insert(cardModel: CardModel)

    suspend fun updateProductToCard(cardModel: CardModel)

    fun loadCoffeeFromCard(): LiveData<List<CardModel>>

    fun loadCoffeeToCardFromCardProduct(idProduct:String): LiveData<List<CardModel>>

    suspend fun deleteProductFromCard(idProduct:Int)

    suspend fun deleteProductToCardFromCardProduct(idProduct:String)

    suspend fun clear()

}