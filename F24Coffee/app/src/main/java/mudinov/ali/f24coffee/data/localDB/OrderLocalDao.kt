package mudinov.ali.f24coffee.data.localDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import mudinov.ali.f24coffee.data.models.OrderLocalModel

@Dao
interface OrderLocalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(orderLocalModel: OrderLocalModel)

}