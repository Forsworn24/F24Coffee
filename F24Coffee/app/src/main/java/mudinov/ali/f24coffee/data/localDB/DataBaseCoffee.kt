package mudinov.ali.f24coffee.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import mudinov.ali.f24coffee.data.models.CardModel
import mudinov.ali.f24coffee.data.models.CoffeeModel
import mudinov.ali.f24coffee.data.models.OrderLocalModel

@Database(entities = [CardModel::class, CoffeeModel::class, OrderLocalModel::class], version = 1)
abstract class DataBaseCoffee: RoomDatabase() {
    abstract val cardDao: CardDao
    abstract val coffeeDao: CoffeeDao
    abstract val orderLocalDao: OrderLocalDao

}
