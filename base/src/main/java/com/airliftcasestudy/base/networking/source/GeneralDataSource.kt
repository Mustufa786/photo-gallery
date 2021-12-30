package com.airliftcasestudy.base.networking.source

import com.airliftcasestudy.base.networking.response.ImagesResponse


/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
interface GeneralDataSource {



    suspend fun getAllImages(search : String?,page : Int) : ImagesResponse
}
