package com.ilkeruzer.nasa.ui.fragment.opportunity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ilkeruzer.nasa.databinding.FragmentOpportunityBinding
import com.ilkeruzer.nasa.ui.fragment.BaseFragment
import org.koin.android.ext.android.inject

class OpportunityFragment : BaseFragment<OpportunityViewModel>() {

    private val vM by inject<OpportunityViewModel>()
    private lateinit var binding: FragmentOpportunityBinding

    override fun equalsViewModel(savedInstanceState: Bundle?) {
        viewModel = vM
    }

    override fun getViewBindingRoot(inflater: LayoutInflater, container: ViewGroup?): View? {
        binding = FragmentOpportunityBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun getViewModel(): Class<OpportunityViewModel> {
        return OpportunityViewModel::class.java
    }

    override fun viewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("OpportunityFragment", "viewCreated: ${viewModel.testString()}")
    }


}