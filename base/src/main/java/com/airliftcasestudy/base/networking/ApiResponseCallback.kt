package com.airliftcasestudy.base.networking

/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */

sealed class ApiResponseCallback<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T> : ApiResponseCallback<T>()
    class Success<T>(data: T) : ApiResponseCallback<T>(data)
    class Error<T>(message: String?, data: T? = null) : ApiResponseCallback<T>(data, message)

}
