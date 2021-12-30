package com.airliftcasestudy.base.networking.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Mustufa Ansari on 21/08/2021.
 * Email : mustufaayub82@gmail.com
 */
class ImagesResponse {

    @SerializedName("total")
    @Expose
    val total: Long? = null

    @SerializedName("totalHits")
    @Expose
    val totalHits: Long? = null

    @SerializedName("hits")
    @Expose
    val hits: List<Hit>? = null

    inner class Hit {
        @Expose
        val id: Long? = null

        @SerializedName("pageURL")
        @Expose
        val pageURL: String? = null

        @SerializedName("type")
        @Expose
        val type: String? = null

        @SerializedName("tags")
        @Expose
        val tags: String? = null

        @SerializedName("previewURL")
        @Expose
        val previewURL: String? = null

        @SerializedName("previewWidth")
        @Expose
        val previewWidth: Long? = null

        @SerializedName("previewHeight")
        @Expose
        val previewHeight: Long? = null

        @SerializedName("webformatURL")
        @Expose
        val webformatURL: String? = null

        @SerializedName("webformatWidth")
        @Expose
        val webformatWidth: Long? = null

        @SerializedName("webformatHeight")
        @Expose
        val webformatHeight: Long? = null

        @SerializedName("largeImageURL")
        @Expose
        val largeImageURL: String? = null

        @SerializedName("imageWidth")
        @Expose
        val imageWidth: Long? = null

        @SerializedName("imageHeight")
        @Expose
        val imageHeight: Long? = null

        @SerializedName("imageSize")
        @Expose
        val imageSize: Long? = null

        @SerializedName("views")
        @Expose
        val views: Long? = null

        @SerializedName("downloads")
        @Expose
        val downloads: Long? = null

        @SerializedName("collections")
        @Expose
        val collections: Long? = null

        @SerializedName("likes")
        @Expose
        val likes: Long? = null

        @SerializedName("comments")
        @Expose
        val comments: Long? = null

        @SerializedName("user_id")
        @Expose
        val userId: Long? = null

        @SerializedName("user")
        @Expose
        val user: String? = null

        @SerializedName("userImageURL")
        @Expose
        val userImageURL: String? = null
    }
}