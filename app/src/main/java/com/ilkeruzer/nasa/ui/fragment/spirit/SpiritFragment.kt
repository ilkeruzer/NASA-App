package com.ilkeruzer.nasa.ui.fragment.spirit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ilkeruzer.nasa.R
import com.ilkeruzer.nasa.databinding.FragmentSpiritBinding
import com.ilkeruzer.nasa.ui.BaseViewModel
import com.ilkeruzer.nasa.ui.fragment.BaseFragment
import org.koin.android.ext.android.inject

class SpiritFragment : BaseFragment<SpiritViewModel>() {

    private val vM by inject<SpiritViewModel>()
    private lateinit var binding: FragmentSpiritBinding

    override fun equalsViewModel(savedInstanceState: Bundle?) {
        viewModel = vM
    }

    override fun getViewBindingRoot(inflater: LayoutInflater, container: ViewGroup?): View? {
        binding = FragmentSpiritBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun getViewModel(): Class<SpiritViewModel> {
        return SpiritViewModel::class.java
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("SpiritFragment", "viewCreated: ${viewModel.testString()}")
    }


}