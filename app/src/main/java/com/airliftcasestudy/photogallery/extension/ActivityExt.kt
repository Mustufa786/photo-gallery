package com.airliftcasestudy.photogallery.extension

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.airliftcasestudy.photogallery.R


/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProvider.NewInstanceFactory().create(viewModelClass)

fun <T : AppCompatActivity> AppCompatActivity.gotoActivity(targetActivityClass: Class<T>) {
    val intent = Intent(this, targetActivityClass)
    startActivity(intent)
}

fun AppCompatActivity.gotoActivityWithNoHistory(targetActivityClass: Class<*>) {
    val i = Intent(this, targetActivityClass)
    i.flags =
        Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(i)
    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
}

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun AppCompatActivity.shareImage(url: String) {
    var intent: Intent? = null
    try {
        intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(
            Intent.EXTRA_SUBJECT,
            "Check this Image By Pixabay on Airlift Technologies Image Gallery App by clicking the following link :"
        )
        intent.putExtra(Intent.EXTRA_TEXT, url)
        startActivity(Intent.createChooser(intent, "Share Via"))
    } catch (e: java.lang.Exception) {
        e.printStackTrace()
    }
}

fun AppCompatActivity.gotoWebView(url: String) {
    var intent: Intent? = null
    try {
        intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    } catch (e: java.lang.Exception) {
        e.printStackTrace()
    }
}





