package com.airliftcasestudy.photogallery.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import com.airliftcasestudy.base.networking.response.ImagesResponse
import com.airliftcasestudy.photogallery.R
import com.airliftcasestudy.photogallery.databinding.LayoutBottomSheetDialogBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso

/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
class ImageDetailBottomSheet(private val data: ImagesResponse.Hit,private val onClickListener: OnClickListener) : BottomSheetDialogFragment() {
    lateinit var binding: LayoutBottomSheetDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.layout_bottom_sheet_dialog,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.item = data
        binding.listener = onClickListener
        binding.executePendingBindings()
        Glide.with(view.context).load(data.largeImageURL).transform(CenterCrop(),RoundedCorners(40)).into(binding.largeImage)
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    interface OnClickListener{
        fun onClickShare(link : String)
        fun onClickKnowMore(url : String)
    }
}