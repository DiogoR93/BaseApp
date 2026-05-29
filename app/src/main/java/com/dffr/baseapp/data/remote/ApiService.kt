package com.dffr.baseapp.data.remote

import com.dffr.baseapp.data.model.CardDto
import retrofit2.http.GET

interface ApiService {
    @GET("cards")
    suspend fun getCards(): List<CardDto>
}
