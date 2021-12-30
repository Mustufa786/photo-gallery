package com.airliftcasestudy.base.networking.source

import androidx.paging.PagingSource
import com.airliftcasestudy.base.networking.response.ImagesResponse
import com.airliftcasestudy.base.util.InjectUtils


/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
class ImagesDataSource(private val search: String?) : PagingSource<Int, ImagesResponse.Hit>() {
    private val repository = InjectUtils.getGeneralRepository
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImagesResponse.Hit> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = repository.getAllImages(search, nextPageNumber)
            LoadResult.Page(
                data = response.hits!!,
                prevKey = if (nextPageNumber > 0) nextPageNumber - 1 else null,
                nextKey = if (nextPageNumber < response.totalHits!!) nextPageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}