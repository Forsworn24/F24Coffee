package mudinov.ali.f24coffee.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mudinov.ali.f24coffee.data.models.CoffeeModel

@Dao
interface CoffeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(coffeeModel: CoffeeModel)

    @Query("SELECT * FROM coffee_data_table")
    fun loadCoffee(): LiveData<List<CoffeeModel>>

    @Query("DELETE FROM coffee_data_table")
    fun clear()
}