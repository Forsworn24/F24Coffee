package mudinov.ali.f24coffee.presentation.di

import androidx.room.Room
import mudinov.ali.f24coffee.data.dataSource.CoffeeApiDataSource
import mudinov.ali.f24coffee.data.dataSource.CoffeeDataSource
import mudinov.ali.f24coffee.data.dataSourceIMPL.CoffeeApiDataSourceIMPL
import mudinov.ali.f24coffee.data.dataSourceIMPL.CoffeeDataSourceIMPL
import mudinov.ali.f24coffee.data.localDB.CardDB
import mudinov.ali.f24coffee.data.localDB.CofDB
import mudinov.ali.f24coffee.data.repository.CardRepository
import mudinov.ali.f24coffee.data.repository.CoffeeRepository
import mudinov.ali.f24coffee.domain.repository.CardCall
import mudinov.ali.f24coffee.domain.repository.CoffeeCall
import mudinov.ali.f24coffee.domain.useCase.CardUseCase
import mudinov.ali.f24coffee.domain.useCase.CoffeeUseCase
import mudinov.ali.f24coffee.presentation.viewModel.CardViewModel
import mudinov.ali.f24coffee.presentation.viewModel.CoffeeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coffee = module {
    single {
        Room.databaseBuilder(androidContext(), CofDB::class.java,
            "cofDB").build()
    }

    single { get<CofDB>().coffeeDao }


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
        Room.databaseBuilder(androidContext(), CardDB::class.java,
            "db1").build()
    }

    single { get<CardDB>().cardDao }


    single<CardCall> { CardRepository(get()) }

    single { CardUseCase(get()) }

    viewModel { CardViewModel(get()) }

}