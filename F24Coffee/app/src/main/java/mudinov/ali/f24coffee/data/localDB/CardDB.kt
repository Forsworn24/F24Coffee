package mudinov.ali.f24coffee.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import mudinov.ali.f24coffee.data.models.CardModel

@Database(entities = [CardModel::class], version = 1)
abstract class CardDB: RoomDatabase() {
    abstract val cardDao: CardDao
}