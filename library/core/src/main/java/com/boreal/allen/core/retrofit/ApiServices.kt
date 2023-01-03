package com.boreal.allen.core.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiServices {

    @GET
    fun serviceResponseBody(
        @Url url: String
    ): Call<Any>

}