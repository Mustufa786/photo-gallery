package com.airliftcasestudy.base.util

import android.app.Application
import android.content.res.AssetManager
import android.content.res.Resources
import com.airliftcasestudy.base.DaggerApp
import com.airliftcasestudy.base.networking.ApiHostIUrls
import com.airliftcasestudy.base.networking.source.GeneralRepository


/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */

object InjectUtils {

    val appContext: Application
        get() = DaggerApp.component?.getBaseContext()!!

    val resource: Resources
        get() = DaggerApp.component?.getResources()!!

    val asset: AssetManager
        get() = DaggerApp.component?.getAssets()!!

    val getRetrofit: ApiHostIUrls
        get() = DaggerApp.component?.getRetrofit()!!

    val getGeneralRepository: GeneralRepository
        get() = DaggerApp.component?.getGeneralRepository()!!

}