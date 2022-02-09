package mudinov.ali.f24coffee.presentation

import android.app.Application
import mudinov.ali.f24coffee.BuildConfig
import mudinov.ali.f24coffee.presentation.di.coffee
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Koin Android logger
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            //inject Android context
            androidContext(this@App)

            modules(coffee)
        }
    }
}