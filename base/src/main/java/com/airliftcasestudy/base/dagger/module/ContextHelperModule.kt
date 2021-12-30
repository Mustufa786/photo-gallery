package com.airliftcasestudy.base.dagger.module

import android.app.Application
import android.content.res.AssetManager
import android.content.res.Resources
import dagger.Module
import dagger.Provides

/**
 * created by Mustufa Ansari on 21,August,2021
 * Email : mustufaayub82@gmail.com
 */
@Module
class ContextHelperModule {
    @Provides
    fun providesAssets(app: Application): AssetManager {
        return app.assets
    }

    @Provides
    fun providesResources(app: Application): Resources {
        return app.resources
    }
}