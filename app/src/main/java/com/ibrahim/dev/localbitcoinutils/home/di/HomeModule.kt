package com.ibrahim.dev.localbitcoinutils.home.di

import com.ibrahim.dev.localbitcoinutils.home.repository.HomeRepository
import com.ibrahim.dev.localbitcoinutils.home.viewModel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel {
        HomeViewModel(get())
    }

    factory {
        HomeRepository(get())
    }

}

