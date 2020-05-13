package com.ibrahim.dev.localbitcoinutils.app.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ibrahim.dev.localbitcoinutils.app.Utils.hasNetwork
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

private const val CACHE_FILE_SIZE: Long = 30 * 1000 * 1000 // 30 Mib
private const val BASEURL = "https://localbitcoins.com/"

val retrofitModule = module{
    single {
        val cache = providerCache(providerCacheFile(androidContext()))
        okhttp(cache)
    }

    single {
        providerRetrofit(get(),BASEURL)
    }

}


private fun providerInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}

private fun providerCacheFile(context: Context): File {
    return File(context.cacheDir, "okhttp_cache").apply { if (this.exists()) mkdir() }
}

private fun providerCache(fileCache: File) = Cache(fileCache, CACHE_FILE_SIZE) //30Mib Cache

private fun okhttp(cache: Cache) = OkHttpClient.Builder()
    .addInterceptor(providerInterceptor())
    .cache(cache)
    .build()

private fun providerRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit = Retrofit.Builder()
    .baseUrl(url)
    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .client(okHttpClient)
    .build()