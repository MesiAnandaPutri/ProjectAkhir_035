package com.example.projectakhir.repositori

import android.app.Application
import com.example.projectakhir.apiservice.ServiceApiKatalog
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

// Interface untuk mendefinisikan dependensi
interface AppContainer {
    val repositoriDataProduk: RepositoriDataProduk
}

// Implementasi dari AppContainer yang menyediakan instance nyata
class ContainerDataApp : AppContainer {
    // Ganti URL ini dengan alamat IP dan port server backend Anda
    // Gunakan http://10.0.2.2:[PORT] jika backend berjalan di localhost dan Anda menggunakan emulator Android
    private val baseUrl = "http://10.0.2.2:8080/"

    private val json = Json { ignoreUnknownKeys = true } // Tambahkan ini agar lebih toleran terhadap JSON

    // Konfigurasi Retrofit
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    // Membuat service API menggunakan Retrofit
    private val retrofitService: ServiceApiKatalog by lazy {
        retrofit.create(ServiceApiKatalog::class.java)
    }

    // Menyediakan repositori produk
    override val repositoriDataProduk: RepositoriDataProduk by lazy {
        NetworkRepositoriDataProduk(retrofitService)
    }
}

// Kelas Application, pastikan namanya sama dengan yang di AndroidManifest.xml
class AplikasiManageProduk : Application() {
    /** AppContainer instance digunakan oleh seluruh bagian aplikasi */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        // Menggunakan implementasi ContainerDataApp
        container = ContainerDataApp()
    }
}
