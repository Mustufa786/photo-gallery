package com.airliftcasestudy.base.networking

import com.airliftcasestudy.base.networking.response.ImagesResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
interface ApiHostIUrls {
    @Headers(ApiFields.HEADER)
    @GET("/api")
    suspend fun getAllImages(
        @Query("key") key: String = "23007366-58b2248a74d6c440e2f602034",
        @Query("q") search: String? = null,
        @Query("page") page: Int = 1
    ): ImagesResponse


}