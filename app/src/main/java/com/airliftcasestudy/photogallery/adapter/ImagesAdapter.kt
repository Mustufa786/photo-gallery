package com.airliftcasestudy.photogallery.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.airliftcasestudy.base.networking.response.ImagesResponse
import com.airliftcasestudy.photogallery.databinding.ItemPhotoListBinding
import com.airliftcasestudy.photogallery.extension.visible
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
class ImagesAdapter(private val itemClickListener: OnItemClickListener) :
    PagingDataAdapter<ImagesResponse.Hit, ImagesAdapter.ViewHolder>(ImagesComparator) {


    inner class ViewHolder(private val itemBinding: ItemPhotoListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: ImagesResponse.Hit) {
            itemBinding.item = item
            itemBinding.listener = itemClickListener
            itemBinding.executePendingBindings()

            Picasso.get().load(item.largeImageURL).resize(400, 400).centerCrop()
                .into(itemBinding.previewImage, object :
                    Callback {
                    override fun onSuccess() {
                        itemBinding.progressBar.visible(false)
                    }

                    override fun onError(e: Exception?) {

                    }
                })
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPhotoListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    object ImagesComparator : DiffUtil.ItemCallback<ImagesResponse.Hit>() {
        override fun areItemsTheSame(
            oldItem: ImagesResponse.Hit,
            newItem: ImagesResponse.Hit
        ): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: ImagesResponse.Hit,
            newItem: ImagesResponse.Hit
        ): Boolean {
            return oldItem == newItem
        }
    }
}

interface OnItemClickListener{
    fun onItemClick(item : ImagesResponse.Hit)
}