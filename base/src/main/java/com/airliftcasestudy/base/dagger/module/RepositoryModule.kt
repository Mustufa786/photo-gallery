package com.airliftcasestudy.base.dagger.module

import com.airliftcasestudy.base.networking.source.GeneralRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * created by Mustufa Ansari on 21,August,2020
 * Email : mustufaayub82@gmail.com
 */
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun getGeneralRepository(): GeneralRepository {
        return GeneralRepository()
    }

}