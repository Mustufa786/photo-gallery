package com.airliftcasestudy.photogallery

import android.content.Context
import androidx.lifecycle.LifecycleObserver
import com.airliftcasestudy.base.DaggerApp

/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
class PhotoGallery : DaggerApp(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()

        if (application == null) {
            application = this
        }
    }

    companion object {
        var application: PhotoGallery? = null
            private set
        val context: Context
            get() = application!!.applicationContext


    }
}