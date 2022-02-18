package mudinov.ali.f24coffee.presentation.di

import androidx.room.Room
import mudinov.ali.f24coffee.data.dataSource.CoffeeApiDataSource
import mudinov.ali.f24coffee.data.dataSource.CoffeeDataSource
import mudinov.ali.f24coffee.data.dataSourceIMPL.CoffeeApiDataSourceIMPL
import mudinov.ali.f24coffee.data.dataSourceIMPL.CoffeeDataSourceIMPL
import mudinov.ali.f24coffee.data.localDB.DataBaseCoffee
import mudinov.ali.f24coffee.data.repository.CardRepository
import mudinov.ali.f24coffee.data.repository.CoffeeRepository
import mudinov.ali.f24coffee.data.repository.OrderApiRepository
import mudinov.ali.f24coffee.data.repository.OrderLocalRepository
import mudinov.ali.f24coffee.domain.repository.CardCall
import mudinov.ali.f24coffee.domain.repository.CoffeeCall
import mudinov.ali.f24coffee.domain.repository.OrderApiCall
import mudinov.ali.f24coffee.domain.repository.OrderLocalCall
import mudinov.ali.f24coffee.domain.useCase.CardUseCase
import mudinov.ali.f24coffee.domain.useCase.CoffeeUseCase
import mudinov.ali.f24coffee.domain.useCase.OrderApiUseCase
import mudinov.ali.f24coffee.domain.useCase.OrderLocalUseCase
import mudinov.ali.f24coffee.presentation.viewModels.CardViewModel
import mudinov.ali.f24coffee.presentation.viewModels.CoffeeViewModel
import mudinov.ali.f24coffee.presentation.viewModels.OrderApiViewModel
import mudinov.ali.f24coffee.presentation.viewModels.OrderLocalViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coffee = module {
    single {
        Room.databaseBuilder(androidContext(), DataBaseCoffee::class.java,
            "db").build()
    }

    single { get<DataBaseCoffee>().coffeeDao }


    single<CoffeeDataSource> {
        CoffeeDataSourceIMPL(
            get()
        )
    }

    single<CoffeeApiDataSource> {
        CoffeeApiDataSourceIMPL(
            get()
        )
    }

    single<CoffeeCall> { CoffeeRepository(get(),get()) }

    single { CoffeeUseCase(get()) }

    viewModel { CoffeeViewModel(get()) }
}

val card = module{

    single {
        Room.databaseBuilder(androidContext(), DataBaseCoffee::class.java,
            "db0").build()
    }

    single { get<DataBaseCoffee>().cardDao }


    single<CardCall> { CardRepository(get()) }

    single { CardUseCase(get()) }

    viewModel { CardViewModel(get()) }

}

val order = module{

    single {
        Room.databaseBuilder(androidContext(), DataBaseCoffee::class.java,
            "dbS").build()
    }

    single { get<DataBaseCoffee>().orderLocalDao }


    single<OrderLocalCall> { OrderLocalRepository(get()) }

    single { OrderLocalUseCase(get()) }

    viewModel { OrderLocalViewModel(get()) }

}

val orderApi= module{

    single<OrderApiCall> { OrderApiRepository() }

    single { OrderApiUseCase(get()) }

    viewModel { OrderApiViewModel(get()) }

}