package com.ilkeruzer.nasa.ui.custom

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.Nullable
import androidx.fragment.app.DialogFragment
import com.ilkeruzer.nasa.databinding.FragmentDetailDialogBinding
import com.ilkeruzer.nasa.model.Photo
import com.ilkeruzer.nasa.util.ImageLoader
import java.util.*


class DetailDialog : DialogFragment() {

    private var photo: Photo? = null
    private lateinit var binding: FragmentDetailDialogBinding

    companion object {
        fun newInstance(photo: Photo): DetailDialog {
            val detailDialog = DetailDialog()
            Bundle().also {
                it.putParcelable("photo", photo)
                detailDialog.arguments = it
            }

            return detailDialog
        }
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

        dialog!!.window!!.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
        )

        updateUI()
    }

    private fun updateUI() {
        photo?.let {
            ImageLoader.glideImage(binding.imageView,it.img_src)
            binding.roverName.setTxtText(it.rover.name)
            binding.dateTakenText.setTxtText(it.earth_date)
            binding.cameraName.setTxtText(it.camera.full_name)
            binding.statusText.setTxtText(it.rover.status.capitalize(Locale.ROOT))
            binding.roverLaunchDate.setTxtText(it.rover.launch_date)
            binding.roverLandingDate.setTxtText(it.rover.landing_date)
        }

    }
}