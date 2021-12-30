package com.airliftcasestudy.base.dagger.module

import com.airliftcasestudy.base.util.RemoteConstant
import com.airliftcasestudy.base.networking.ApiHostIUrls
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.airliftcasestudy.base.util.NetworkUtil
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * created by Mustufa Ansari on 21,August,2021
 * Email : mustufaayub82@gmail.com
 */


@Module
class NetworkModule {
    @Provides
    @Singleton
    fun getRetrofitInstance(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        coroutineCallAdapterFactory: CoroutineCallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RemoteConstant.RemoteURL)
            .addCallAdapterFactory(coroutineCallAdapterFactory)
            .addConverterFactory(gsonConverterFactory)
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideAPIClient(retrofit: Retrofit): ApiHostIUrls {
        return retrofit.create(ApiHostIUrls::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return NetworkUtil.enableTls12OnPreLollipop().build()
    }

    @Provides
    @Singleton
    fun getGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun getCoroutineCallAdapter(): CoroutineCallAdapterFactory {
        return CoroutineCallAdapterFactory.invoke()
    }
}