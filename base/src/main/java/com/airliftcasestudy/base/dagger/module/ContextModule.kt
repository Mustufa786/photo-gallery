package com.airliftcasestudy.base.dagger.module

import android.app.Application
import dagger.Module
import dagger.Provides

/**
 * created by Mustufa Ansari on 21,August,2021
 * Email : mustufaayub82@gmail.com
 */
@Module
class ContextModule(var mApplication: Application?) {

    @Provides
    fun providesContext(): Application {
        return mApplication!!
    }
}