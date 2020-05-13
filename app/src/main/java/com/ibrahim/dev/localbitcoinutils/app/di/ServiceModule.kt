package com.ibrahim.dev.localbitcoinutils.app.di

import com.ibrahim.dev.localbitcoinutils.home.api.HomeApi
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module{
    single {
        get<Retrofit>().create(HomeApi::class.java)
    }
}