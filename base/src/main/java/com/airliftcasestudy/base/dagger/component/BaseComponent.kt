package com.airliftcasestudy.base.dagger.component

import android.app.Application
import android.content.res.AssetManager
import android.content.res.Resources
import com.airliftcasestudy.base.dagger.module.ContextHelperModule
import com.airliftcasestudy.base.dagger.module.NetworkModule
import com.airliftcasestudy.base.dagger.module.RepositoryModule
import com.airliftcasestudy.base.networking.ApiHostIUrls
import com.airliftcasestudy.base.networking.source.GeneralRepository
import dagger.Component
import javax.inject.Singleton

/**
 * created by Mustufa Ansari on 21,August,2021
 * Email : mustufaayub82@gmail.com
 */
@Singleton
@Component(
    modules = [ContextHelperModule::class,NetworkModule::class, RepositoryModule::class],
    dependencies = [ContextComponent::class]
)
interface BaseComponent {
    /**
     * base application context
     */
    fun getBaseContext(): Application

    /**
     * android resources
     */
    fun getResources(): Resources

    /**
     * android assets
     */
    fun getAssets(): AssetManager

    /**
     * retrofit Host Url instance for API calls
     */
    fun getRetrofit(): ApiHostIUrls

    /**
     * MVVM repo
     */
    fun getGeneralRepository(): GeneralRepository
}