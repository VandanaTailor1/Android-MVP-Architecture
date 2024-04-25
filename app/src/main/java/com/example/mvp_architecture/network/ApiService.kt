package com.example.mvp_architecture.network

import com.example.mvp_architecture.model.ListModel
import retrofit2.http.GET

interface ApiService {

    @GET("/random")
    suspend fun getData() : List<ListModel>

}