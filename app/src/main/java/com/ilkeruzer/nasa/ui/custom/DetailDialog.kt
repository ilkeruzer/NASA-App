package com.ilkeruzer.nasa.ui.custom

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.Nullable
import androidx.fragment.app.DialogFragment
import com.ilkeruzer.nasa.R
import com.ilkeruzer.nasa.databinding.FragmentDetailDialogBinding
import com.ilkeruzer.nasa.model.Photo
import com.ilkeruzer.nasa.util.ImageLoader
import java.util.*


class DetailDialog : DialogFragment() {

    private var photo: Photo? = null
    private lateinit var binding: FragmentDetailDialogBinding

    fun newInstance(photo: Photo): DetailDialog {
        val detailDialog = DetailDialog()
        Bundle().also {
            it.putParcelable("photo", photo)
            detailDialog.arguments = it
        }

        return detailDialog
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable("photo", photo)
        super.onSaveInstanceState(outState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailDialogBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle: Bundle? = savedInstanceState ?: arguments
        if (bundle != null) {
            photo = bundle.getParcelable("photo")
            Log.d("DetailDialog", "onViewCreated: $photo")
        }
        updateUI()
        dialog!!.window!!.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
        )



    }

    private fun updateUI() {
        photo?.let {
            ImageLoader.glideImage(binding.imageView,it.img_src)
            binding.roverName.append(" " + it.rover.name)
            binding.dateTakenText.append(" " +it.earth_date)
            binding.cameraName.append(" " + it.camera.full_name)
            binding.statusText.append(" " + it.rover.status.capitalize(Locale.ROOT))
            binding.roverLaunchDate.append(" " + it.rover.launch_date)
            binding.roverLandingDate.append(" " + it.rover.landing_date)
        }

    }
}