package com.ilkeruzer.nasa.ui.fragment.curiosity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ilkeruzer.nasa.IBaseListener
import com.ilkeruzer.nasa.databinding.FragmentCuriosityBinding
import com.ilkeruzer.nasa.model.Photo
import com.ilkeruzer.nasa.ui.adapter.RoverAdapter
import com.ilkeruzer.nasa.ui.fragment.BaseFragment
import org.koin.android.ext.android.bind
import org.koin.android.ext.android.inject

class CuriosityFragment : BaseFragment<CuriosityViewModel>(), IBaseListener.Adapter<Photo> {

    private val vM by inject<CuriosityViewModel>()
    private lateinit var binding: FragmentCuriosityBinding
    private val roverAdapter by inject<RoverAdapter>()
    private var listSize : Int = 1

    //TODO: MainActivity AppBar Eklenik kamerelar oraya eklenecek

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
        initRecycler()
        setData()

    }

    private fun setData() {
        viewModel.getLiveData(camera = "MAST").observe(this, {
            binding.recList.visibility = View.VISIBLE
            roverAdapter.notifyReload(it)
            listSize = roverAdapter.itemCount
        })
    }

    private fun initRecycler() {
        binding.recList.apply {
            setGridColumn(2)
            adapter = roverAdapter
        }
        roverAdapter.setOnActionListener(this)
    }

    override fun onItemClick(item: Photo, position: Int) {

    }

    override fun onLoadMore(itemCount: Int) {
        val page = (itemCount / listSize) + 1
        viewModel.getLiveData(page = page,camera = "MAST").observe(this, {
            Log.d("CuriosityFragment", "onLoadMore: $it ")
            roverAdapter.notifyDataSet(it)
        })
    }


}