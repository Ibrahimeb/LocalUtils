package com.ibrahim.dev.localbitcoinutils.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ibrahim.dev.localbitcoinutils.home.repository.HomeRepository
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    val compositeDisposable = CompositeDisposable()

    val price = MutableLiveData<String>()

    fun getPriceByEquiation(equation:String){
       compositeDisposable.add(repository.getPriceByEquiation(equation).subscribe(
           {price.value = it.data},
           {price.value = it.message}
       ))
    }

}