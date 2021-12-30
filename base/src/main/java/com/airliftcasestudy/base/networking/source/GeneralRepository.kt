package com.airliftcasestudy.base.networking.source

import com.airliftcasestudy.base.networking.response.ImagesResponse
import com.airliftcasestudy.base.util.InjectUtils

/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
class GeneralRepository : GeneralDataSource {
    override suspend fun getAllImages(search: String?, page: Int): ImagesResponse {
        return InjectUtils.getRetrofit.getAllImages(search = search, page = page)
    }

}