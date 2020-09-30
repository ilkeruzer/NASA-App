package com.ilkeruzer.nasa.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ilkeruzer.nasa.ui.BaseViewModel

abstract class BaseFragment<VM: BaseViewModel>() : Fragment() {

    protected lateinit var viewModel: VM


    override fun onCreate(savedInstanceState: Bundle?) {
        equalsViewModel(savedInstanceState)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getViewBindingRoot(inflater,container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewCreated(view,savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.unSubscribeViewModel()
    }

    protected abstract fun equalsViewModel(savedInstanceState: Bundle?)
    protected abstract fun getViewBindingRoot(inflater: LayoutInflater,container: ViewGroup?): View?
    protected abstract fun getViewModel(): Class<VM>
    protected abstract fun viewCreated(view: View, savedInstanceState: Bundle?)
}