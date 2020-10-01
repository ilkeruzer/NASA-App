package com.ilkeruzer.nasa.ui.fragment.spirit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ilkeruzer.nasa.IBaseListener
import com.ilkeruzer.nasa.R
import com.ilkeruzer.nasa.databinding.FragmentSpiritBinding
import com.ilkeruzer.nasa.model.Photo
import com.ilkeruzer.nasa.ui.BaseViewModel
import com.ilkeruzer.nasa.ui.adapter.RoverAdapter
import com.ilkeruzer.nasa.ui.custom.CameraBottomSheet
import com.ilkeruzer.nasa.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class SpiritFragment : BaseFragment<SpiritViewModel>(), IBaseListener.Adapter<Photo>,
    CameraBottomSheet.CameraListener{

    private val vM by inject<SpiritViewModel>()
    private lateinit var binding: FragmentSpiritBinding
    private val roverAdapter by inject<RoverAdapter>()
    private var listSize : Int = 1
    private lateinit var cameraBottomSheet: CameraBottomSheet
    private var cameraCode : String? = null

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
        setData()
        filterIconClick()
    }

    private fun filterIconClick() {
        activity!!.imageFilterIcon.setOnClickListener {
            cameraBottomSheet = CameraBottomSheet().newInstance("Spirit")
            cameraBottomSheet.show(activity!!.supportFragmentManager, cameraBottomSheet.tag)
            cameraBottomSheet.setListener(this)
        }
    }

    private fun setData(camera: String? = null) {
        showLoading()
        viewModel.getLiveData(camera = camera).observe(this, {
            Log.d("SpiritFragment", "setData: ")
            if (it == null || it.size == 0) recyclerNullItem()
            else initRecycler()
            stopLoading()
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

    private fun recyclerNullItem() {
        binding.recList.apply {
            setRecyclerView(true)
            adapter = roverAdapter
        }
        roverAdapter.setOnActionListener(this)
    }

    override fun onItemClick(item: Photo, position: Int) {

    }

    override fun onLoadMore(itemCount: Int) {
        val page = (itemCount / listSize) + 1
        showLoading()
        viewModel.getLiveData(page = page, camera = cameraCode).observe(this, {
            Log.d("SpiritFragment", "onLoadMore: $it ")
            stopLoading()
            roverAdapter.notifyDataSet(it)
        })
    }

    override fun listViewClickListener(position: Int) {
        cameraCode = resources.getStringArray(R.array.spirit_code)[position]
        Log.d("SpiritFragment", "listViewClickListener: $cameraCode")
        setData(cameraCode)
    }

    override fun onResume() {
        super.onResume()
        filterIconClick()
    }

}