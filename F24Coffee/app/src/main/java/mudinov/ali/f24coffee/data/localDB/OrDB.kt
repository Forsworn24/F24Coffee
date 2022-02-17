package mudinov.ali.f24coffee.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import mudinov.ali.f24coffee.data.models.OrderLocalModel

@Database(entities = [OrderLocalModel::class], version = 1)
abstract class OrDB: RoomDatabase() {
    abstract val orderLocalDao: OrderLocalDao
}
