package com.ilkeruzer.nasa.ui.custom

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ilkeruzer.nasa.R


class CameraBottomSheet : BottomSheetDialogFragment() {

    private var itemType = ""
    private var listItem: Array<String>? = null
    private var listView: ListView? = null
    private lateinit var cameraBottomSheet: CameraBottomSheet
    private lateinit var listener: CameraListener


    fun newInstance(type: String?): CameraBottomSheet {
        cameraBottomSheet = CameraBottomSheet()
        val bundle = Bundle()
        bundle.putString("type", type)
        cameraBottomSheet.arguments = bundle
        return cameraBottomSheet
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("type", itemType)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle: Bundle? = savedInstanceState ?: arguments
        if (bundle != null) {
            itemType = bundle.getString("type", "")
        }
    }

    private fun initListItem() {
        when (itemType){
            "Curiosity" -> { listItem = resources.getStringArray(R.array.curiosity_camera) }
            "Opportunity" -> { listItem = resources.getStringArray(R.array.opportunity_camera) }
            "Spirit" -> { listItem = resources.getStringArray(R.array.spirit_camera)  }
            else  -> {}
        }
    }

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        val contentView = View.inflate(context, R.layout.camera_bottom_sheet_layout, null)
        dialog.setContentView(contentView)
        dialog.setCancelable(false)
        listView = contentView.findViewById(R.id.listView)
        updateUI()
    }

    private fun updateUI() {
        initListItem()
        listView!!.setBackgroundResource(R.color.cardView_current_bg)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            context!!,
            R.layout.camera_list_item, R.id.list_content, listItem!!
        )
        listView!!.adapter = adapter
        listView!!.onItemClickListener =
            OnItemClickListener { _, _, position, _ ->
                run {
                    listener.let {
                        dismiss()
                        it.listViewClickListener(position)
                    }
                }
            }
    }

    fun setListener(listener: CameraListener) {
        this.listener = listener
    }

    interface CameraListener {
        fun listViewClickListener(position: Int)
    }
}