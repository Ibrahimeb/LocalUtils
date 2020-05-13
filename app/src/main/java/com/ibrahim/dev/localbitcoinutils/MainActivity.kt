package com.ibrahim.dev.localbitcoinutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.ibrahim.dev.localbitcoinutils.databinding.ActivityMainBinding
import com.ibrahim.dev.localbitcoinutils.home.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getPriceByEquiation("btc_in_usd")

        viewModel.price.observe(this, Observer {
            textView.text = it
        })
    }
}
