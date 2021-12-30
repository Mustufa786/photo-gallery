package com.airliftcasestudy.base.util

import android.content.Context
import android.net.ConnectivityManager
import com.airliftcasestudy.base.R
import java.util.concurrent.TimeoutException

/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
object K {
    object RetrofitConstants {
        const val RETROFIT_METHOD_POST = "post"
        const val RETROFIT_METHOD_GET = "get"
    }


    object IntentKeys{
        const val DATA = "DATA"
    }

    private fun isNetworkConnected(): Boolean {
        val cm =
            InjectUtils.appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }
    fun throwErrorMessage(exception: Throwable): String {
        var errorMsg: String = InjectUtils.resource.getString(R.string.error_msg_unknown)
        if (!isNetworkConnected()) {
            errorMsg = InjectUtils.resource.getString(R.string.error_msg_no_internet)
        } else if (exception is TimeoutException) {
            errorMsg = InjectUtils.resource.getString(R.string.error_msg_timeout)
        }
        return errorMsg

    }

}