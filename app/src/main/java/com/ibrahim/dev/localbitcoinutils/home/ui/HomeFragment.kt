package com.ibrahim.dev.localbitcoinutils.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.ibrahim.dev.localbitcoinutils.R
import com.ibrahim.dev.localbitcoinutils.databinding.FragmentHomeBinding
import com.ibrahim.dev.localbitcoinutils.home.viewModel.HomeViewModel
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getPriceByEquiation("btc_in_usd")
    }

    private fun subscribeLiveData(){
        viewModel.price.observe(this, Observer {
            binding.textViewPrice.text = it
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeLiveData()
    }



}
