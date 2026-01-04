package com.example.projectakhir.repositori

import android.app.Application
import com.example.projectakhir.apiservice.ServiceApiKatalog
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val repositoriDataProduk: RepositoriDataProduk
}

class ContainerDataApp : AppContainer {

    private val baseUrl = "http://10.0.2.2:3000/"

    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: ServiceApiKatalog by lazy {
        retrofit.create(ServiceApiKatalog::class.java)
    }

    override val repositoriDataProduk: RepositoriDataProduk by lazy {
        NetworkRepositoriDataProduk(retrofitService)
    }
}

class AplikasiManageProduk : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp()
    }
}
