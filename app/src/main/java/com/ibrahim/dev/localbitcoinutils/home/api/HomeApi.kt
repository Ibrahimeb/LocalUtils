package com.ibrahim.dev.localbitcoinutils.home.api

import com.ibrahim.dev.localbitcoinutils.home.models.ResponsePriceEquation
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeApi {
    @GET("api/equation/{equ}")
    fun getPriceByEquation(@Path("equ") equation: String): Observable<ResponsePriceEquation>
}