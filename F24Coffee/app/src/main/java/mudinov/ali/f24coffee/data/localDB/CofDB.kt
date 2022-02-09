package mudinov.ali.f24coffee.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import mudinov.ali.f24coffee.data.models.CoffeeModel

@Database(entities = [CoffeeModel::class], version = 1)
abstract class CofDB: RoomDatabase() {
    abstract val coffeeDao: CoffeeDao
}