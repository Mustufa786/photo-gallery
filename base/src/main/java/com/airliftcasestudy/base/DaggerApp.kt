package com.airliftcasestudy.base

import androidx.multidex.MultiDexApplication
import com.airliftcasestudy.base.dagger.component.BaseComponent
import com.airliftcasestudy.base.dagger.component.DaggerBaseComponent
import com.airliftcasestudy.base.dagger.component.DaggerContextComponent
import com.airliftcasestudy.base.dagger.module.ContextModule


/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
open class DaggerApp : MultiDexApplication() {

    companion object {
        var component: BaseComponent? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        val applicationComponent = DaggerContextComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()

        component = DaggerBaseComponent.builder()
            .contextComponent(applicationComponent)
            .build()


    }


}