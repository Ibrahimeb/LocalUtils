package com.ibrahim.dev.localbitcoinutils.home.repository

import com.ibrahim.dev.localbitcoinutils.app.applySchedulers
import com.ibrahim.dev.localbitcoinutils.home.api.HomeApi
import com.ibrahim.dev.localbitcoinutils.home.models.ResponsePriceEquation
import io.reactivex.Observable

class HomeRepository(private val api:HomeApi){

    fun getPriceByEquiation(equation: String): Observable<ResponsePriceEquation> {
        return api.getPriceByEquation(equation).applySchedulers()
    }

}