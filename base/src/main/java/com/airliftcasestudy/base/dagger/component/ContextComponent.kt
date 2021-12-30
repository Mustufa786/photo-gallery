package com.airliftcasestudy.base.dagger.component

import android.app.Application
import com.airliftcasestudy.base.dagger.module.ContextModule
import dagger.Component

/**
 * created by Mustufa Ansari on 21,August,2021
 * Email : mustufaayub82@gmail.com
 */
@Component(modules = [ContextModule::class])
interface ContextComponent {
    fun getContext(): Application

}