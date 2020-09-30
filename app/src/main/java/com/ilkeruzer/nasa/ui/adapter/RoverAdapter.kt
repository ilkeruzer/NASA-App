package com.ilkeruzer.nasa.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilkeruzer.nasa.Constant
import com.ilkeruzer.nasa.IBaseListener
import com.ilkeruzer.nasa.databinding.ItemRoverLayoutBinding
import com.ilkeruzer.nasa.model.Photo
import com.ilkeruzer.nasa.util.ImageLoader

class RoverAdapter (
    list: ArrayList<Photo?>,
    isMultipleType: Boolean
) : BaseRecyclerAdapter<Photo>(list,isMultipleType) {

    private lateinit var binding: ItemRoverLayoutBinding

    override fun onBindBaseViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val ob: Photo = mListObjects!![position]!!
        when (getItemViewType(position)) {
            Constant.ITEMTYPE.ONETYPE -> {
                val vH: RoverHolder = holder as RoverHolder
                listener?.let { vH.bind(ob, it) }
            }
        }
    }

    override fun onCreateBaseViewHolder(v: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemRoverLayoutBinding.inflate(LayoutInflater.from(v!!.context),v,false)
        return RoverHolder(binding)
    }

    class RoverHolder (binding: ItemRoverLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        private var imageView = binding.imageView

        fun bind(
            photo: Photo,
            listener: IBaseListener.Adapter<Photo>
        ) {
            ImageLoader.glideImage(imageView,photo.img_src)

            itemView.setOnClickListener { listener.onItemClick(photo,adapterPosition) }
        }

    }

}