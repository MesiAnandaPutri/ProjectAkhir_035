package com.example.projectakhir.apiservice

import com.example.projectakhir.modeldata.DataProduk
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ServiceApiKatalog {

    @GET("api/products")
    suspend fun getProduk(): List<DataProduk>

    @POST("api/products")
    suspend fun postProduk(@Body dataProduk: DataProduk): Response<Void>

    @GET("api/products/{id}")
    suspend fun getSatuProduk(@Path("id") id: Int): DataProduk

    @PUT("api/products/{id}")
    suspend fun editSatuProduk(@Path("id") id: Int, @Body dataProduk: DataProduk): Response<Void>

    @DELETE("api/products/{id}")
    suspend fun hapusSatuProduk(@Path("id") id: Int): Response<Void>
}
