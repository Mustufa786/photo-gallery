package com.airliftcasestudy.photogallery.adapter

import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BaseObservable
import androidx.databinding.BindingAdapter
import com.airliftcasestudy.photogallery.databinding.TagsLayoutBinding
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
object BindingAdapter : BaseObservable() {
    @BindingAdapter("setImageByImageUrlUsingPicassoOnCircularImageView")
    @JvmStatic
    fun setImageByImageUrlUsingPicassoOnCircularImageView(
        imageView: CircleImageView,
        imageUrl: String?
    ) {
        if (!imageUrl.isNullOrEmpty())
            Picasso.get().load(imageUrl).into(imageView)

    }

    @BindingAdapter("setImageByUrl")
    @JvmStatic
    fun setImageByUrl(
        imageView: AppCompatImageView,
        imageUrl: String?
    ) {
        if (!imageUrl.isNullOrEmpty())
            Picasso.get().load(imageUrl).resize(400, 400).centerCrop().into(imageView)

    }

    @BindingAdapter("showTagsInLinearLayout")
    @JvmStatic
    fun showTagsInLinearLayout(linearLayout: LinearLayout, tags: String) {
        val tagsList = tags.split(",")
        tagsList.forEach {
            val bi = TagsLayoutBinding.inflate(LayoutInflater.from(linearLayout.context), null, false)
            bi.tag.text = it
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(15,0,0,0)
            linearLayout.addView(bi.root,params)
        }

    }
}