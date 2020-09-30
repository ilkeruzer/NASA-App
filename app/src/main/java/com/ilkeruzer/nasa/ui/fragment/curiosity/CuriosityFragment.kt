package com.ilkeruzer.nasa.ui.fragment.curiosity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ilkeruzer.nasa.databinding.FragmentCuriosityBinding
import com.ilkeruzer.nasa.ui.fragment.BaseFragment
import org.koin.android.ext.android.inject

class CuriosityFragment : BaseFragment<CuriosityViewModel>() {

    private val vM by inject<CuriosityViewModel>()
    private lateinit var binding: FragmentCuriosityBinding

    override fun equalsViewModel(savedInstanceState: Bundle?) {
        viewModel = vM
    }

    override fun getViewBindingRoot(inflater: LayoutInflater, container: ViewGroup?): View? {
        binding = FragmentCuriosityBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun getViewModel(): Class<CuriosityViewModel> {
        return CuriosityViewModel::class.java
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("CuriosityFragment", "viewCreated: ${viewModel.testString()}")
    }




}