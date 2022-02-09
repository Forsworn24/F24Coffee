package mudinov.ali.f24coffee.data.dataSource

import android.content.Context

interface CoffeeApiDataSource {
    fun startMigration (context: Context)
}