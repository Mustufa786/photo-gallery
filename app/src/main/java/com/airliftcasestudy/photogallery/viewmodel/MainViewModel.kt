package com.airliftcasestudy.photogallery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.airliftcasestudy.base.networking.ApiResponseCallback
import com.airliftcasestudy.base.networking.response.ImagesResponse
import com.airliftcasestudy.base.networking.source.ImagesDataSource
import com.airliftcasestudy.base.util.InjectUtils
import com.airliftcasestudy.base.util.K.throwErrorMessage
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
class MainViewModel : ViewModel() {


    val images =  Pager(PagingConfig(pageSize = 20)) { ImagesDataSource(null) }.flow.cachedIn(
        viewModelScope
    )

}