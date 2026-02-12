package com.beginina.data.storages

import com.beginina.data.dto.TelegramUserDto
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TelegramAuthApi {
    @POST("checkUser")
    suspend fun login(
        @Body user: TelegramUserDto
    ): Response<ResponseBody>
}