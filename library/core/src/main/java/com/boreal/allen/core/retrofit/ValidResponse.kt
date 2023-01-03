package com.boreal.allen.core.retrofit

import com.boreal.allen.core.domain.DataResponse
import com.boreal.allen.core.domain.StatusRequestEnum
import com.google.gson.Gson
import retrofit2.Call
import kotlin.reflect.KClass

class ValidResponse<R>(
    private val vkClass: KClass<*>
) {
    fun validationMethod(result: Call<R>): DataResponse<R> = try {
        val requestExecuted = result.execute()
        val gson = Gson()
        if (requestExecuted.isSuccessful && requestExecuted.code() == 200) {
            val jsonObject = gson.toJsonTree(requestExecuted.body())
            val myResponse =
                Gson().fromJson(jsonObject, vkClass.javaObjectType) as R
            DataResponse(
                status = StatusRequestEnum.SUCCESS,
                response = myResponse
            )
        } else {
            DataResponse(
                status = StatusRequestEnum.FAILURE,
                failure = "Hay una intermitencia en la red, por favor,\n " +
                        "intente mas tarde, si el problema persiste,\n " +
                        "envie un correo al administrador."
            )
        }
    } catch (exception: Exception) {
        DataResponse(
            status = StatusRequestEnum.FAILURE,
            failure = "Hay una intermitencia en la red por favor,\n " +
                    "intente mas tarde, si el problema persiste,\n " +
                    "envie un correo al administrador."
        )
    }
}