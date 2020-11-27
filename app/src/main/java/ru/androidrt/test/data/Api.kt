package ru.androidrt.test.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.androidrt.test.data.model.PicturesResponse

interface Api {
    @GET("api/")
    suspend fun getPictures(@Query("key") key: String, @Query("per_page") count: Int = 100): PicturesResponse
}